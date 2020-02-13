package test.pack.dao;

import java.util.List;

public interface UserDAO {

     String userLogin(String loginName);
     void addUserToBD(String userName, String password);
     boolean checkingLoginCount(String login);

     Integer getIdByUserLogin(String login);
     List<String> getAllLogins();
}
