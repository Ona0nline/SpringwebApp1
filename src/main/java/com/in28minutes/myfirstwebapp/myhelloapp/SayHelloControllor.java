package com.in28minutes.myfirstwebapp.myhelloapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Need to add annotation to let springboot know what kind of class this is
//Controllor handles web requests
@Controller
public class SayHelloControllor {

//    This will only invoke when this url is invoked
//    http://localhost:9091/say-hello
    @RequestMapping("/say-hello")
//    Response body will return whatver is returned, as is to the browser
    @ResponseBody
    public String sayHello(){
//        when you return a string, spring mvc will be looking for a view
        return "Hello! What are you learning today?";
    }

//    Will be on a different page
    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
//        Building html string - too complex should rather use views
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<head>");
        stringBuffer.append("<title> My first Html page title!</title>");
        stringBuffer.append("</head>");
        stringBuffer.append("<body>");
        stringBuffer.append("My first html body");
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");

        return stringBuffer.toString();
    }


    @RequestMapping("/say-hello-jsp")

    public String sayHellojsp(){
        return "say-hello-jsp";
    }
}
