package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {

    @GetMapping("/admin/signin")
    public String showSigninForm(Model model) {
        return "/admin/signin";  // ログイン画面を表示
    }
}
