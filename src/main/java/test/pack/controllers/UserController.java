package test.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import test.pack.Question;
import test.pack.dao.AnswerDB;
import test.pack.services.QuestionService;


import java.util.List;

@Controller
//@RequestMapping("/test")
public class UserController {
    @Autowired
    private AnswerDB answerDB;

    @Autowired
    QuestionService service;

    //Добавление вопроса и ответа
    /*@GetMapping("/game")
    public String userEditForm(@RequestParam String q,
                               @RequestParam String a) {
        answerDB.addAnswersToBD(q, a, true);
        return answerDB.findAllAnswers().toString();
    }*/

    @GetMapping("/")
    public String getMain(){
        return "main";
    }

    @GetMapping("/game")
    public ModelAndView startTest() {
        List<Question> list = service.prepare5Quests();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        modelAndView.addObject("qList", list);
        //model.addAttribute("qList", list);
        return modelAndView;
    }
}
