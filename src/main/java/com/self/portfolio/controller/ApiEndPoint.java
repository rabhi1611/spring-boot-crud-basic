package com.self.portfolio.controller;

import com.self.portfolio.model.UserDetail;
import com.self.portfolio.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class ApiEndPoint {

    UserService userService;
    ApiEndPoint(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    String basicCheck(){
        return "Working!";
    }

    @GetMapping(value = "fetchData", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDetail> fetchData(){
        return userService.fetchUsers();
    }


    @PostMapping(value = "fetchData", consumes = MediaType.APPLICATION_JSON_VALUE)
    Object postData(@RequestBody UserDetail userDetail){
        return userService.postUsers(userDetail);
    }

    @PostMapping(value = "deleteData")
    void deleteData(@RequestBody UserDetail userDetail){
        userService.deleteUsers(userDetail);
    }
}
