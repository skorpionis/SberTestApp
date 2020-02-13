package test.pack.dao.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import test.pack.dao.UserDAO;

import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    String loginRequest = "SELECT login FROM LOGIN_TABLE WHERE login=?;";
    String addLoginSQL = "INSERT INTO LOGIN_TABLE (login, password) VALUES (?, ?);";
    String idByLogin = "SELECT id from LOGIN_TABLE WHERE login = ?";

    @Override
    public String userLogin(String loginName) {

        List<Map<String, Object>> loginMap = jdbcTemplate.queryForList(loginRequest, loginName);
        return (String) loginMap.get(0).get("login");
    }

    @Override
    public void addUserToBD(String userName, String password) {

        jdbcTemplate.update(addLoginSQL, userName, password);
    }

    public boolean checkingLoginCount(String login) {
        String loginRequest = "SELECT COUNT(login) FROM LOGIN_TABLE WHERE login=?;";
        Integer s = jdbcTemplate.queryForObject(loginRequest, Integer.class, login);
        return s == 0;
    }

    @Override
    public List<String> getAllLogins() {
        return null;
    }

    @Override
    public Integer getIdByUserLogin(String login) {
        return jdbcTemplate.queryForObject(idByLogin, Integer.class, login);
    }
}
