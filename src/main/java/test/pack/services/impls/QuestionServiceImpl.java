package test.pack.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.pack.model.Question;
import test.pack.dao.QuestionDAO;
import test.pack.model.Task;
import test.pack.services.QuestionService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionServiceImpl(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    public Map<Question, Map<String, Boolean>> prepareQuestsForTask() {
        Map<Question, Map<String, Boolean>> map = new HashMap<>();
        while (map.size() < 5) {
            map.put(questionDAO.getRandomQuestion(), new HashMap<>());
        }
        return map;
    }

    @Override
    public void addQuestion(String question, String answers, boolean questionType, Integer userId) {
        questionDAO.addQuestion(question, answers, questionType, userId);
    }

    @Override
    public Task createTask() {
        Task task = new Task();
        Map<Question, Map<String, Boolean>> questions = prepareQuestsForTask();

        for (Map.Entry<Question, Map<String, Boolean>> pair: questions.entrySet()) {
            Question question = pair.getKey();
            pair.setValue(questionDAO.collectAnswers(question.getRightAnswer()));
            pair.getValue().put(question.getQuestion(), false);
        }

        task.setQuestions(questions);
        return task;
    }
}
