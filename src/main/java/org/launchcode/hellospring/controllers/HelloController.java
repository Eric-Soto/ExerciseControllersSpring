package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller


public class HelloController {

    // Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

    // lives /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodBye() {
        return "Goodbye, Spring";
    }


    // Create a handler that handles requests of the form /hello?launchcode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloFo")
    //@ResponseBody
    public String helloWithQueryParam(@RequestParam String name, String language, Model model) {

        String testGreet = createMessage(name, language);
        model.addAttribute("greeting",testGreet);
        return "hello";
    }

    public static String createMessage(String name, String language){
        String greeting = "";
        if(language.equals("Spanish")){
            greeting = "Hola, ";
        }
        else if(language.equals("English")){
            greeting = "Hello, ";
        }
        else if(language.equals("Portuguese")){
            greeting = "Olá, ";
        }
        else if(language.equals("French")){
            greeting = "Bonjour, ";
        }
        else if(language.equals("Italian")){
            greeting = "Ciao, ";
        }
        else{
            greeting = "#@#@#$! ";
        }
        greeting =  greeting + name ;
        return greeting;
    }

    //Handler that handles request of the form /hello/launchcode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello,  " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    //hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList();
        names.add("Launchcode");
        names.add("Javascript");
        names.add("Java");

        model.addAttribute("names",names);
        return "hello-list";
    }
}

