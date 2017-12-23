package bd.ac.seu.helloworldjpa.configuration;

import bd.ac.seu.helloworldjpa.model.Student;
import bd.ac.seu.helloworldjpa.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class StudentWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) {
        try {
            builder
                    .inMemoryAuthentication()
                        .withUser("kmh")
                        .password("abc")
                        .authorities("ROLE_USER")
                    .and()
                        .withUser("sm")
                        .password("test")
                        .authorities("ROLE_ADMIN");
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
