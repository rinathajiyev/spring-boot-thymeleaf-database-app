package com.company.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
       return http
                .authorizeRequests(auth ->{
                    auth.antMatchers("/students").hasAnyAuthority("ADMIN", "USER");
                    auth.antMatchers("/showSaveForm", "/showUpdateForm", "/deleteStudent", "/addStudent").hasAuthority("ADMIN");
                })
               .httpBasic()
               .and()
               .formLogin(formLogin -> formLogin.defaultSuccessUrl("/students"))
               .logout(logout -> {
                   logout.logoutUrl("/logout");
                   logout.deleteCookies("JSESSIONID");
               })
               .csrf(csrf -> csrf.disable())
               .build();
    }
}
