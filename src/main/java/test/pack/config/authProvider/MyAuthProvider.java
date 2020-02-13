package test.pack.config.authProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import test.pack.services.impls.UserServiceImpl;

import java.util.ArrayList;

@Component
public class MyAuthProvider implements AuthenticationProvider {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();

        boolean loginExist = userServiceImpl.isLoginExist(login);
        if (loginExist) {
            return new UsernamePasswordAuthenticationToken(login, authentication.getPrincipal(), new ArrayList<>());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
