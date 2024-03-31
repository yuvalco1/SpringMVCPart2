package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
public class MyController {
    //localhost:8080/myapp/ -> do something1:
    //localhost:8080/myapp/greet/ -> do something 2:
    // return html page where will be hello world         <html><head><body> <h1> hello world </h2> </body></html>

    private static Map<String, String> usersFromDB = Map.of("name1", "Arja", "name2", "John");

    //Model:
    //("name1", "Arja",
    // "name2", "John")
    //"mode", "we are sad today)

    @RequestMapping("/greet/{name}")
    public ModelAndView greet(@RequestParam String mode, @PathVariable("name") String name){
        System.out.println("catched request!");
        System.out.println(mode);
        ModelAndView modelAndView = new ModelAndView("greet", usersFromDB);
        String message = mode.equals("happy") ? "we are happy today :)" : "we are sad today :(";
        modelAndView.addObject("mode", message);
        modelAndView.addObject("param", name);
        return modelAndView;
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    public MyController() {
        System.out.println("Controller created!");
    }

}
