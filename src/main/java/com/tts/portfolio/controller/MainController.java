package com.tts.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/design")
    public String designPage() {

        return "design";
    }



}