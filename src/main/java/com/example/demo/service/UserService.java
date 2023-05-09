package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userDAO.findById(id);
    }

    @Transactional
    public User saveUser(User user) {
        return userDAO.save(user);
    }

    @Transactional
    public void deleteUserById(Long id) {
        userDAO.deleteById(id);
    }
}

