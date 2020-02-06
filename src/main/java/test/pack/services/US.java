package test.pack.services;

import java.util.List;

public interface US {

    boolean checkIfExistsUser(String login);

    List<String> getAllLogins();
}
