package test.pack.services;

import test.pack.model.Question;
import test.pack.model.Task;

import java.util.Map;

public interface QuestionService {

    Map<Question, Map<String, Boolean>> prepareQuestsForTask();

    void addQuestion(String question, String answers, boolean questionType, Integer userId);

    Task createTask();


}
