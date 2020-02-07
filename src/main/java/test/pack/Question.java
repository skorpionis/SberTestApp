package test.pack;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return questType == question1.questType &&
                Objects.equals(question, question1.question);
    }

    @Override
    public int hashCode() {

        return Objects.hash(question, questType);
    }
}
