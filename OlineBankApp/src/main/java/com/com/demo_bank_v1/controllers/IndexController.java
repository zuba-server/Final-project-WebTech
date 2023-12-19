package com.com.demo_bank_v1.controllers;

import com.com.demo_bank_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private final UserRepository userRepository;

    public IndexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("PageTitle", "Home");
        System.out.println("In Index Page Controller");
        return "index";
    }

    @GetMapping("/error")
    public String getError(Model model) {
        model.addAttribute("PageTitle", "Errors");
        System.out.println("In Error Page Controller");
        return "error";
    }

    @GetMapping("/verify")
    public String getVerify(
            @RequestParam("token") String token,
            @RequestParam("code") String code,
            Model model) {
        // Set View:
        String dbToken = userRepository.checkToken(token);

        if (dbToken == null) {
            model.addAttribute("error", "This Session Has Expired");
            return "error";
        }

        userRepository.verifyAccount(token, code);

        model.addAttribute("success", "Account Verified Successfully, Please proceed to Log In!");

        System.out.println("In Verify Account Controller");
        return "login";
    }
    // End Of User Account Verification.
}
