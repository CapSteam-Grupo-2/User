package com.capgeticket.user.controller;

import com.capgeticket.user.converter.UserConverter;
import com.capgeticket.user.errors.BadRequestException;
import com.capgeticket.user.model.User;
import com.capgeticket.user.response.UserResponse;
import com.capgeticket.user.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody User user) {
        var response = service.addUser(user);
        if (response.isEmpty()){
            throw new BadRequestException(user.getMail());
        }
        return ResponseEntity.ok(converter.of(response.get()));
    }
}
