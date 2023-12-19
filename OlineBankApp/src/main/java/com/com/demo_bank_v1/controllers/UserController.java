//package com.com.demo_bank_v1.controllers;
//
//import com.com.demo_bank_v1.models.User;
//import com.com.demo_bank_v1.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/welcome")
//    public String welcome(Model model) {
//        User user = userService.getCurrentUser();
//        model.addAttribute("user", user);
//        return "dashboard";
//    }
//}
