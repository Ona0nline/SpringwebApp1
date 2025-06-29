package com.in28minutes.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.spi.ToolProvider;

@Controller
@SessionAttributes("name")

public class ToDoControllor {
    private ToDoService toDoService;
//    make use of todo service to populate todos
    public ToDoControllor(ToDoService toDoService){
        super();
        this.toDoService = toDoService;
    }


    @RequestMapping("/list_todos")
    public String listAllTodos(ModelMap model){
        String username = (String)model.get("name");
        List<Todo> todos = toDoService.findByUsername(username);
        model.put("todos", todos);
        return "listTodos";
    }

//    Jsp link == Requestmapping link --> Returns jsp with relevent sesssion info or model info
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodos(ModelMap modelMap){
        String username = (String)modelMap.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusWeeks(3),false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodos(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedinUsername();
        toDoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list_todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id){

        toDoService.deletebyid(id);
        return "redirect:list_todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap){
        Todo todo = toDoService.findById(id);
        modelMap.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodos(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
//        Post request redirects you back to list todos page
        String username = getLoggedinUsername();
        todo.setUsername(username);
        toDoService.updateTodo(todo);
        return "redirect:list_todos";
    }


    private static String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
