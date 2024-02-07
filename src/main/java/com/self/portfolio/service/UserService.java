package com.self.portfolio.service;

import com.self.portfolio.model.UserDetail;
import com.self.portfolio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDetail> fetchUsers() {
        return userRepository.findAll();
    }

    public Object postUsers(UserDetail userDetail) {
        return userRepository.save(userDetail);
    }

    public void deleteUsers(UserDetail userDetail) {
        userRepository.delete(userDetail);
    }
}