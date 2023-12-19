package com.com.demo_bank_v1.controllers;

import com.com.demo_bank_v1.helpers.Token;
import com.com.demo_bank_v1.models.User;
import com.com.demo_bank_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(){
        System.out.println("In Login Page Controller");
        ModelAndView getLoginPage = new ModelAndView("login");
        // Set Token String:
        String token = Token.generateToken();
        // Send Token to View:
        getLoginPage.addObject("token", token);
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("_token") String token,
                        Model model,
                        HttpSession session) {

        // Validate input fields / form data
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            model.addAttribute("error", "Username or Password Cannot be Empty");
            return "login";
        }

        // Check if email exists
        String getEmailInDatabase = userRepository.getUserEmail(email);

        // Check If Email Exists
        if (!StringUtils.hasText(getEmailInDatabase)) {
            model.addAttribute("error", "Something went wrong please contact support");
            return "error";
        }

        // Get Password In Database
        String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);

        // Validate Password
        if (!BCrypt.checkpw(password, getPasswordInDatabase)) {
            model.addAttribute("error", "Incorrect Username or Password");
            return "login";
        }

        // Proceed to log the user in
        User user = userRepository.getUserDetails(getEmailInDatabase);

        // Set Session Attributes
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);

        return "redirect:/app/dashboard";
    }

}
