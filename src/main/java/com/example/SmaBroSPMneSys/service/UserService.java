package com.example.SmaBroSPMneSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmaBroSPMneSys.domain.User;
import com.example.SmaBroSPMneSys.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> searchAll() {
        return userRepository.findAll();
    }
}