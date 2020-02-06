package test.pack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import test.pack.config.authProvider.MyAuthProvider;
import test.pack.services.UserService;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "test.pack")
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    MyAuthProvider provider;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/registration").permitAll()   //разрешает войти по таким адресам + папка
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.loginPage("/loging")
                .defaultSuccessUrl("/game")
                .failureForwardUrl("/main")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }


    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user1");
    }*/


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }
}
