package test.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import test.pack.Question;
import test.pack.dao.AnswerDB;
import test.pack.services.QuestionService;
import test.pack.services.UserService;

import java.security.Principal;
import java.util.Set;

@Controller
//@RequestMapping("/test")
public class UserController {
    @Autowired
    private AnswerDB answerDB;

    @Autowired
    QuestionService service;

    @Autowired
    UserService userService;

    //Добавление вопроса и ответа
    /*@GetMapping("/game")
    public String userEditForm(@RequestParam String q,
                               @RequestParam String a) {
        answerDB.addAnswersToBD(q, a, true);
        return answerDB.findAllAnswers().toString();
    }*/

    @GetMapping("/")
    public String getMain() {
        return "main";
    }

    @GetMapping("/game")
    public ModelAndView startTest() {
        Set<Question> set = service.prepare5Quests();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        modelAndView.addObject("qSet", set);
        return modelAndView;
    }

    @GetMapping("/questions")
    public String getNewQuestions() {
        return "questions";
    }

    @PostMapping("/questions")
    public String addNewAnswersAndQuestions(Principal principal, Model model, String question, String answer, boolean typeOfAnswers) {
        String authenticatedUser = principal.getName();
        Integer userId = userService.getIdByLogin(authenticatedUser);
        answerDB.addAnswersToBD(question, answer, typeOfAnswers, userId);
        model.addAttribute("successPutting", "Успешно добавлено");
        return "questions";
    }
}
