package com.hand.springboothello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String indexAll(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "login";
    }
}
