package test.pack;

import java.util.Map;

public class Question {

    private String question;
    private Map<String, Boolean> answers;
    private boolean questType;

    public Question(String question, Map<String, Boolean> answers, boolean questType) {
        this.question = question;
        this.answers = answers;
        this.questType = questType;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Boolean> answers) {
        this.answers = answers;
    }

    public boolean isQuestType() {
        return questType;
    }

    public void setQuestType(boolean questType) {
        this.questType = questType;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                ", questType=" + questType +
                '}';
    }
}
