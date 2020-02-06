package test.pack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.pack.Question;
import test.pack.dao.AnswerDB;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private AnswerDB answerDB;


    public List<Question> prepare5Quests(){
        List<Question> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(answerDB.getRandomQuestion());
        }
        return list;
    }

}
