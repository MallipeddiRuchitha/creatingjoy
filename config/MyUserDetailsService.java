package com.technocrats.creatingjoy.config;

import com.technocrats.creatingjoy.dto.UserDTO;
import com.technocrats.creatingjoy.entity.User;
import com.technocrats.creatingjoy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        log.info("username "+username);

        UserDTO theUser = userService.findByUserName(username);
        log.info("user"+theUser);


        if(theUser==null)
            throw new UsernameNotFoundException("user not found");

        return new CurrentUser(theUser);
    }

}
