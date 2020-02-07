package test.pack.dao;


import test.pack.Question;

import java.util.List;

public interface AnswerDB {

     List<String> findAllAnswers();
     void addAnswersToBD(String question, String answer, boolean type, Integer usersId);

     Question getRandomQuestion();
}
