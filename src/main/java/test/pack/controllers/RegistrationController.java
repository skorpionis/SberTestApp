package test.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.pack.services.UserService;

@Controller
//@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String openPage(){
        return "registration";
    }

   @GetMapping("/loging")
    public String loginpage() {
        return "loging";
    }

    @PostMapping("/registration")
    public String registrationAppearence(String userName, Model model) {
        if (userService.checkIfExistsUser(userName)) {
            return "redirect:/login";
        } else {
            model.addAttribute("usernameError", "Логин '" + userName + "' уже существует, введите новый уникальный логин");
            return "registration";
        }
    }

}
