package test.pack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import test.pack.model.Question;
import test.pack.model.Task;
import test.pack.services.QuestionService;
import test.pack.services.UserService;

import java.security.Principal;
import java.util.Map;
import java.util.Set;

@Controller
public class UserController {

    private Task task;

    private final QuestionService qService;

    private final UserService uService;

    public UserController(QuestionService qService, UserService uService) {
        this.qService = qService;
        this.uService = uService;
    }

    @GetMapping("/")
    public String getMain() {
        return "main";
    }

    @GetMapping("/game")
    public String startTest(Model model) {
        task = qService.createTask();
        model.addAttribute("quests", task.getQuestions());
        return "game";
    }

    @PostMapping("/game")  //Для получени инфы по ответам пользователя
    public String getUsersAnswers(Model model, Map<Question, Map<String, Boolean>> quests) {

        Task res = task;
        System.out.println();
        //Task task = qService.createTask();
        //model.addAttribute("quests", task.getQuestions());
        return "game";
    }

    @GetMapping("/questions")
    public String getNewQuestions() {
        return "questions";
    }

    @PostMapping("/questions")
    public String addNewAnswersAndQuestions(Principal principal, Model model, String question, String answer, boolean typeOfAnswers) {
        String authenticatedUser = principal.getName();
        Integer userId = uService.getIdByLogin(authenticatedUser);
        qService.addQuestion(question, answer, typeOfAnswers, userId);
        model.addAttribute("successPutting", "Успешно добавлено");
        return "questions";
    }
}
