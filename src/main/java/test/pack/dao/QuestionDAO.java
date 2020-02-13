package test.pack.dao;


import test.pack.model.Question;

import java.util.List;
import java.util.Map;

public interface QuestionDAO {

    List<String> findAllAnswers();

    void addQuestion(String question, String answer, boolean type, Integer usersId);

    void addAnswers(String... answers);

    Question getRandomQuestion();

    Map<String, Boolean> collectAnswers(String rightAns);
}
