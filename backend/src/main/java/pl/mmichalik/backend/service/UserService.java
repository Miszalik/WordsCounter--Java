package pl.mmichalik.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JdbcUserDetailsManager userDetailsManager;



    @Autowired
    public UserService(JdbcUserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    public void addUser(String username, String password) {
        userDetailsManager.createUser(User.withUsername(username)
                //.password(passwordEncoder.encode(password))
                .roles("USER")
                .build());
    }
}