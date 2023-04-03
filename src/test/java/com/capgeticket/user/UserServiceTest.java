package com.capgeticket.user;

import com.capgeticket.user.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(UserServiceImpl.class)
public class UserServiceTest {

    @Test
    public void addUser(){

    }
}
