package test.pack.services;

import java.util.List;

public interface UserService {
    boolean checkIfExistsUser(String login, String password);

    boolean isLoginExist(String login);

    List<String> getAllLogins();

    Integer getIdByLogin(String login);
}
