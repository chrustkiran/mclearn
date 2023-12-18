package com.mclearn.admin.controller;


import com.mclearn.admin.dto.UserDTO;
import com.mclearn.admin.dto.request.UserReq;
import com.mclearn.admin.service.UserService;
import com.mclearn.admin.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<Boolean> addStudent(@RequestBody UserReq userReqDTO) {
        log.info("[addStudent]-[controller]-executing");
        ValidatorUtil.validateUserReq(userReqDTO);
        return new ResponseEntity<>(userService.saveUser(userReqDTO), HttpStatus.OK);
    }

    public ResponseEntity<List<UserDTO>> getAllStudents() {
        log.info("[getAllStudents]-[controller]-getAllStudents");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
