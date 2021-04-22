package com.abcbank.topup.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ROLE_USER = "USER";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll() //
                .antMatchers(HttpMethod.POST, "/login").permitAll() //
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String defaultUser = "admin";
        String defaultPassword = "admin";
 
        String encrytedPassword = this.passwordEncoder().encode(defaultPassword);
        System.out.println("Encoded password of admin=" + encrytedPassword);
 
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> //
        mngConfig = auth.inMemoryAuthentication();
 
        UserDetails admin = User.withUsername(defaultUser).password(encrytedPassword).roles(ROLE_USER).build();
        mngConfig.withUser(admin);
    }
     
}