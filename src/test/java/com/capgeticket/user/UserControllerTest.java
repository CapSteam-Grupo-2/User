package com.capgeticket.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.capgeticket.user.controller.UserController;
import com.capgeticket.user.converter.UserConverter;
import com.capgeticket.user.model.User;
import com.capgeticket.user.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	private User user;

	@Autowired
	private UserController controller;

	@MockBean
	private UserConverter converter;

	@MockBean
	private UserService service;

	@BeforeEach
	private void addData() {
		user.setName("nameTest");
		user.setLastname("lastnameTest");
		user.setMail("emailTest7");
		user.setDate("04/04/2023");
		user.setPassword("PasswordTest");
	}

	@Test
	public void addUserTest_resposeOK() throws Exception {
		when(service.addUser(user)).thenReturn(Optional.of(user));
		assertThat(controller.addUser(user)).isEqualTo(ResponseEntity.ok().body(converter.of(user)));
	}
	
	@Test
	public void addUserTest_respose(){
		
		when(service.addUser(user)).thenReturn(Optional.empty());
		assertThat(controller.addUser(user)).isEqualTo(ResponseEntity.badRequest());
	}
	
	

}
