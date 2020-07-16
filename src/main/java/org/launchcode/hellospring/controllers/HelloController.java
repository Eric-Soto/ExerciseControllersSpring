package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody

public class HelloController {

    // Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

    // lives /hello/goodbye
    @GetMapping("goodbye")

    public String goodBye() {
        return "Goodbye, Spring";
    }


    // Create a handler that handles requests of the form /hello?launchcode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")

    public String helloWithQueryParam(@RequestParam String name, String language) {


        return createMessage(name, language);
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

        return "<b>" + greeting + name + " !</b>";
    }

    //Handler that handles request of the form /hello/launchcode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {

        return "hello, " + name;
    }

    //hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit request to /hello
                "<input type= 'text' name='name'>" +
                "<select name='language'>" +
                "<option value=''>--Please choose a language--</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='English'>English</option>" +
                "<option value='Portuguese'>Portuguese</option>" +
                "<option value='French'>French</option>" +
                "<option value='Italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}