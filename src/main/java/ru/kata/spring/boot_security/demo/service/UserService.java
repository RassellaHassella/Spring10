package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {
     void add(User user);

     void createRolesIfNotExist();

     List<User> usersList();

     void update(User user);

     void delete(Long id);

     User getUser(Long id);

     User findByEmail(String email);


}