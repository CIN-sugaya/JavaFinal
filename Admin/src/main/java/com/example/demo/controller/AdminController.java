package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.AdminForm;
import com.example.demo.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("adminForm", new AdminForm());
        return "admin/signup";  // 新規登録用のテンプレート名
    }

    @PostMapping("/admin/signup")
    public String submitSignupForm(AdminForm adminForm) {
        adminService.saveAdmin(adminForm);  // サービスにデータを渡して保存
        return "redirect:/admin/signin";  // 登録後にログインページにリダイレクト
    }
}
