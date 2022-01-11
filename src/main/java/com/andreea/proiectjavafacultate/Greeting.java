package com.andreea.proiectjavafacultate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Greeting {

    @RequestMapping("/hello")
    public @ResponseBody String greeting()
    {
        return "Hello";
    }
}
