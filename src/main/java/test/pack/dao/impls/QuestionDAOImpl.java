package test.pack.dao.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import test.pack.dao.QuestionDAO;
import test.pack.model.Question;

import java.util.*;

@Component
public class QuestionDAOImpl implements QuestionDAO {

    private final JdbcTemplate jdbcTemplate;

    private static List<Integer> questionsIds;

    private static final String selectAllAnswersQuery = "SELECT answer FROM ANSWERS_TABLE";
    private static final String getAnswerQuery = "SELECT answer FROM ANSWERS_TABLE WHERE id = ?";
    private static final String addRightAnswerQuery = "INSERT INTO ANSWERS_TABLE (answer) VALUES (?)";
    private static final String getRightAnswerIdQuery = "SELECT id FROM ANSWERS_TABLE WHERE answer=? limit 1";
    private static final String addQuestionQuery = "INSERT INTO QUESTIONS_TABLE (question, answer_id, user_id, quest_type) VALUES (?, ?, ?, ?)";

    private static final String questionIdsListQuery = "SELECT id from QUESTIONS_TABLE";

    private static final String getRandomQuestionQuery = "SELECT question, answer_id, quest_type FROM QUESTIONS_TABLE WHERE id = ?";

    @Autowired
    public QuestionDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> findAllAnswers() {
        return jdbcTemplate.queryForList(selectAllAnswersQuery, String.class);
    }

    @Override
    public void addQuestion(String question, String answer, boolean type, Integer usersID) {
        jdbcTemplate.update(addRightAnswerQuery, answer);
        Integer answerId = jdbcTemplate.queryForObject(getRightAnswerIdQuery, Integer.class, answer);
        jdbcTemplate.update(addQuestionQuery, question, answerId, usersID, type);
    }

    @Override
    public Question getRandomQuestion() {

        questionsIds = jdbcTemplate.queryForList(questionIdsListQuery, Integer.class);
        Collections.shuffle(questionsIds);
        //Получение случайного id вопроса и удаление его из списка questionsIds
        Integer id = questionsIds.remove(0);

        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(getRandomQuestionQuery, id);
        String quest = (String) stringObjectMap.get("question");

        Integer right_ans_id = (Integer) stringObjectMap.get("answer_id");
        String rightAnswer = jdbcTemplate.queryForObject(getAnswerQuery, String.class, right_ans_id);
        Boolean questType = (Boolean) stringObjectMap.get("quest_type");

        Question question = new Question(quest, rightAnswer, questType);
        return question;
    }


    @Override
    public Map<String, Boolean> collectAnswers(String rightAns){
        HashMap<String, Boolean> res =
                jdbcTemplate.queryForList("SELECT distinct answer FROM ANSWERS_TABLE WHERE answer != ? limit 3;", String.class, rightAns)
                        .stream().collect(HashMap::new, (map, ans) -> map.put(ans, false), HashMap::putAll);
        res.put(rightAns, false);
        return res;
    }


    @Override
    public void addAnswers(String... answers) {

    }


}
