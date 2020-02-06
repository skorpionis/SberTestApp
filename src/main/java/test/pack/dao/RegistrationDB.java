package test.pack.dao;

import java.util.List;

public interface RegistrationDB {

     String userLogin(String loginName);
     void addUserToBD(String userName);
     boolean checkingLoginCount(String login);

     List<String> getAllLogins();
}
