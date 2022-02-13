package org.smart.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/",
                        "/board/boardList",
                        "/board/boardDetail",
                        "/guestbook/**",
                        "/account/register",
                        "/images/**", "/style/**", "/script/**").permitAll()
                .anyRequest().authenticated() // 위의 설정 외에는 모두 로그인을 해야 함
                .and()
           .formLogin()
                .loginPage("/account/loginForm").loginProcessingUrl("/account/login").permitAll()
                .usernameParameter("usrid")
                .passwordParameter("usrpwd")
                .and()
           .logout()
                .logoutSuccessUrl("/").permitAll()
                .and()
                .cors()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                // 인증 (로그인) ==> mapper 작업 필요 없음
                .usersByUsernameQuery("select usrid username, usrpwd password, enabled " +
                        "from \"member\" " +
                        "where usrid = ? ")
                // 권한
                .authoritiesByUsernameQuery("select usrid username, rolename role_name " +
                        "from \"member\" " +
                        "where usrid = ? ");
    }

    // 단방향 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

