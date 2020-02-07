package test.pack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.pack.dao.RegistrationDB;

import java.util.List;

@Service
public class UserService implements US {
    @Autowired
    RegistrationDB registrationDB;

    public boolean checkIfExistsUser(String login) {
        if (!isLoginExist(login)) {
            if (!login.equals("")) {
                registrationDB.addUserToBD(login);
            }
            return true;
        } else
            return false;
    }

    public boolean isLoginExist(String login) {
        return !registrationDB.checkingLoginCount(login);
    }

    @Override
    public List<String> getAllLogins() {
        return null;
    }

    public Integer getIdByLogin(String login) {
        return registrationDB.getIdByUserLogin(login);
    }
}
