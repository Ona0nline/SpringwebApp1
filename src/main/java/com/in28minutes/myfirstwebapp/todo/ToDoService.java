package com.in28minutes.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
//    It’s a static initializer block: it runs once when the class is loaded.
//
//It allows you to perform more complex static initialization logic than you can do in a one-liner.
    static{
        todos.add(new Todo(++todosCount, "Ona","Learning Springboot" ,LocalDate.now().plusYears(1), false));
    todos.add(new Todo(++todosCount, "Nkululeko","Learning how to not say the Lords name in vain" ,LocalDate.now().plusYears(7), false));
    todos.add(new Todo(++todosCount, "Taro","Learning AI" ,LocalDate.now().plusYears(2), false));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetdate, boolean done){
        Todo todo = new Todo(++todosCount, username,description,targetdate,false);
        todos.add(todo);
    }

    public void deletebyid(int id){
//        A predicate is a condition
//        todo -> todo.getID() == id. Basically remove todo if todo.getID == to the id passed in
         Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo =todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deletebyid(todo.getId());
        todos.add(todo);
    }
}
