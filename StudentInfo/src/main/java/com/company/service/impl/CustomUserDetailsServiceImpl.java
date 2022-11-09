package com.company.service.impl;

import com.company.dao.*;
import com.company.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import static org.springframework.security.core.userdetails.User.*;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Students student = studentRepository.findByEmail(email);

       if(student != null){
           User.UserBuilder userBuilder = withUsername(email);

           userBuilder.disabled(false);
           userBuilder.password(student.getPassword());

           String[] authorities = new String[]{"ADMIN"};
           userBuilder.authorities(authorities);

           return userBuilder.build();
       } else {
           throw new UsernameNotFoundException("Student does not exist!");
       }
    }
}
