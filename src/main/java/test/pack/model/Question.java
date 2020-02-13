package test.pack.model;

import java.util.Objects;

public class Question {

    private String question;
    private String rightAnswer;
    private User creator = null;
    private Boolean questType; // true - с выбором ответа

    public Question(String question, String rightAnswer, boolean questType) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.questType = questType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public boolean isQuestType() {
        return questType;
    }

    public void setQuestType(boolean questType) {
        this.questType = questType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return questType == question1.questType &&
                Objects.equals(question, question1.question) &&
                Objects.equals(rightAnswer, question1.rightAnswer) &&
                Objects.equals(creator, question1.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, rightAnswer, creator, questType);
    }
}
