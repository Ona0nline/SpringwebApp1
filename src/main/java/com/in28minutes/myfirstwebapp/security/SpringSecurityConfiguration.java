package com.in28minutes.myfirstwebapp.security;

import org.eclipse.tags.shaded.org.apache.xpath.patterns.FunctionPattern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
//    InMemoryUserDetailsManager

    @Bean
    public InMemoryUserDetailsManager createuserDetailsManager(){

        UserDetails userDetails1 = createNewUser("Onalerona", "mommy");
        UserDetails userDetails2 = createNewUser("Bubba", "password");
        UserDetails userDetails3 = createNewUser("User", "visitor");


        return new InMemoryUserDetailsManager(userDetails1,userDetails2, userDetails3);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password).roles("USER", "ADMIN").build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
