package test.pack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.pack.Question;
import test.pack.dao.AnswerDB;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionService {

    @Autowired
    private AnswerDB answerDB;


    public Set<Question> prepare5Quests() {
        Set<Question> set = new HashSet<>();
        while (set.size() < 5) {
            set.add(answerDB.getRandomQuestion());
        }
        return set;
    }

    public void addAnswersToBD(String question, String answers, boolean questionType, Integer userId) {
        answerDB.addAnswersToBD(question, answers, questionType, userId);
    }


    /*@Override
    public void addAnswersToBD(String question, String answer, boolean type) {
        jdbcTemplate.update(addAnswersSQL, answer);
        Integer answerId = jdbcTemplate.queryForObject("SELECT id FROM ANSWERS_TABLE
        WHERE answer=? limit 1", Integer.class, answer);
        jdbcTemplate.update(addQuestionsSQL, question, answerId);

    }*/

}
