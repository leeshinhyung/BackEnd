package com.capstone.dayj.Oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2Controller {
    @GetMapping("/loginForm")
    public String home(){
        return "loginForm";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "adminPage";
    }
}