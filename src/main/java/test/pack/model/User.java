package test.pack.model;


import java.util.Map;
import java.util.Objects;

public class User {

    private String login;
    private String password;
    private Map<Question, String> usersAnswers;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<Question, String> getUsersAnswers() {
        return usersAnswers;
    }

    public void setUsersAnswers(Map<Question, String> usersAnswers) {
        this.usersAnswers = usersAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(usersAnswers, user.usersAnswers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, usersAnswers);
    }
}
