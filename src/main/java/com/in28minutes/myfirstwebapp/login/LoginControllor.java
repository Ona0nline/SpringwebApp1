package com.in28minutes.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//No longer needing login code because all of it will be handled by spring security

@Controller
@SessionAttributes("name")

public class LoginControllor {
//    private Logger logger = LoggerFactory.getLogger(getClass());
    private AuthenticationService authenticationService;

    public LoginControllor(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotologinpage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String gotowelcomepage(@RequestParam String name, @RequestParam String password, ModelMap model){

        if(authenticationService.authenticate(name,password)){
            model.put("name", name);
            return "welcome";
        }
//        Whenever you want to pass messages to and from the view, you use models
        model.put("errorMessage", "Invalid message! Please try again!");
        return "login";

    }

}
