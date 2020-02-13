package test.pack.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.pack.dao.UserDAO;
import test.pack.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean checkIfExistsUser(String login, String password) {
        if (!isLoginExist(login)) {
            if (!login.equals("")) {
                userDAO.addUserToBD(login, password);
            }
            return true;
        } else
            return false;
    }

    @Override
    public boolean isLoginExist(String login) {

        return !userDAO.checkingLoginCount(login);
    }

    @Override
    public List<String> getAllLogins() {
        return null;
    }

    @Override
    public Integer getIdByLogin(String login) {
        return userDAO.getIdByUserLogin(login);
    }
}
