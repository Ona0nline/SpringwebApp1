package com.in28minutes.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
//Making a Spring bean out of it so that it can be auto instantiated and autowired
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isValidUserName = username.equalsIgnoreCase("Ona");
        boolean isValidPassword = password.equalsIgnoreCase("dadio");


        return isValidUserName && isValidPassword;
    }
}
