package test.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import test.pack.services.UserService;

@Controller
public class RegistrationController {

    @Autowired
    UserService uService;

    @GetMapping("/registration")
    public String openPage() {
        return "registration";
    }

    @GetMapping("/loging")
    public String loginpage() {
        return "loging";
    }

    @PostMapping("/registration")
    public String registrationAppearence(String login, String password, Model model) {
        if (uService.checkIfExistsUser(login, password)) {
            return "redirect:/login";
        } else {
            model.addAttribute("usernameError", "Логин '" + login + "' уже существует, введите новый уникальный логин");
            return "registration";
        }
    }

}
