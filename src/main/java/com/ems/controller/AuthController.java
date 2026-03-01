package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
