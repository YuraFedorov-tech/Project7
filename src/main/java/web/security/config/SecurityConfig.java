package web.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 *
 *@Data 10.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */
@Configuration
@EnableWebSecurity
//@ComponentScan("web.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/hello/**").permitAll()
                    .antMatchers("/changeUser/**").hasAuthority("ADMIN")
                    .antMatchers("/addUser/**").permitAll()
                    .antMatchers("/admin/**","/crud/**").hasAuthority("ADMIN")
                    .antMatchers("/user/**").authenticated()
                .and()
                    .formLogin()
                    .usernameParameter("name")
                    .defaultSuccessUrl("/")
                    .loginPage("/login")
                .permitAll();
        http.csrf().disable();
    }

}
