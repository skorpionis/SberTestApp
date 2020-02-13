package test.pack.model;

import java.util.Map;

public class Task {

    /**
     * Имитирует список 5 неповторяющихся вопросов.
     * Map<String, Boolean> - String - ответ на вопрос из ключа внешней мапы,
     *                          Boolean - true если юзер выбрал этот ответ
     */
    private Map<Question, Map<String, Boolean>> questions;

    public Map<Question, Map<String, Boolean>> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<Question, Map<String, Boolean>> questions) {
        this.questions = questions;
    }
}
