package com.self.portfolio.service;

import com.self.portfolio.model.UserDetail;
import com.self.portfolio.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDetail> fetchUsers() {
        return userRepository.findAll();
    }

    public Object postUsers(UserDetail userDetail) {
        return userRepository.save(userDetail);
    }

    public ResponseEntity<?> deleteUsers(UserDetail userDetail) {
        if(Optional.ofNullable(userDetail.getId()).isPresent() && userRepository.findById(userDetail.getId()).isPresent()) {
            userRepository.delete(userDetail);
            return ResponseEntity.ok("User deleted!");
        }else {
            return new ResponseEntity<>("User not found",HttpStatus.BAD_REQUEST);
        }
    }
}