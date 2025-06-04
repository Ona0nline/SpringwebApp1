package com.in28minutes.myfirstwebapp.login;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

//No longer needing login code because all of it will be handled by spring security

@Controller
@SessionAttributes("name")

public class WelcomeControllor {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotowelcomepage(ModelMap modelMap){
        modelMap.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
