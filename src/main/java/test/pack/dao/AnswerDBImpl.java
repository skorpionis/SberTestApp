package test.pack.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import test.pack.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class AnswerDBImpl implements AnswerDB {




    @Autowired
    JdbcTemplate jdbcTemplate;

    private static Integer questionsCount;

    String selectAllAnswerFromBd = "SELECT answer FROM ANSWERS_TABLE";
    String addAnswersSQL = "INSERT INTO ANSWERS_TABLE (answer) VALUES (?);";
    String addQuestionsSQL = "INSERT INTO QUESTIONS_TABLE (question, answer_id) VALUES (?, ?);";

    String questionsCountSQL = "SELECT COUNT(question) from QUESTIONS_TABLE;";
    String getRandomQuestSQL = "SELECT question, answer_id FROM QUESTIONS_TABLE WHERE id = ?";

    @Override
    public List<String> findAllAnswers() {
        return jdbcTemplate.queryForList(selectAllAnswerFromBd, String.class);
    }

    @Override
    public void addAnswersToBD(String question, String answer, boolean type) {
        jdbcTemplate.update(addAnswersSQL, answer);
        Integer answerId = jdbcTemplate.queryForObject("SELECT id FROM ANSWERS_TABLE WHERE answer=? limit 1", Integer.class, answer);
        jdbcTemplate.update(addQuestionsSQL, question, answerId);
        
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random(17);

        questionsCount = jdbcTemplate.queryForObject(questionsCountSQL, Integer.class);

        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(getRandomQuestSQL, random.nextInt(questionsCount));
        String quest = (String) stringObjectMap.get("question");
        Integer ans_id = (Integer)stringObjectMap.get("answer_id");
        return new Question(quest, collect4Ans(ans_id), false);
    }

    private Map<String, Boolean> collect4Ans(int rightAnsId){
        HashMap<String, Boolean> res =
                jdbcTemplate.queryForList("SELECT distinct answer FROM ANSWERS_TABLE WHERE id != ? limit 3;", String.class, rightAnsId)
                .stream().collect(HashMap::new, (map, ans) -> map.put(ans, false), HashMap::putAll);
        String rightAns = (String)jdbcTemplate.queryForMap("SELECT answer FROM ANSWERS_TABLE WHERE id = ?", rightAnsId).get("answer");
        res.put(rightAns, true);
        return res;
    }
}
