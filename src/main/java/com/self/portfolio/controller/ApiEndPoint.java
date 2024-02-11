package com.self.portfolio.controller;

import com.self.portfolio.model.UserDetail;
import com.self.portfolio.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class ApiEndPoint {

    private final UserService userService;
    ApiEndPoint(UserService userService){
        this.userService = userService;
    }
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    String basicCheck(){
        return "Working!";
    }

    // Get Request to fetch all the users
    @GetMapping(value = "fetchData", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDetail> fetchData(){
        return userService.fetchUsers();
    }

    // POST request for creating and updating the existing user
    @PostMapping(value = "createUpdateData", consumes = MediaType.APPLICATION_JSON_VALUE)
    Object postData(@Valid @RequestBody UserDetail userDetail){
        return userService.postUsers(userDetail);
    }

    // Post request for deleting the user according to generated user iD
    @PostMapping(value = "deleteData")
    ResponseEntity<?> deleteData(@RequestBody UserDetail userDetail){
        return userService.deleteUsers(userDetail);
    }
}
