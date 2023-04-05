package com.capgeticket.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.capgeticket.user.controller.UserController;
import com.capgeticket.user.converter.UserConverter;
import com.capgeticket.user.model.User;
import com.capgeticket.user.response.UserResponse;
import com.capgeticket.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private UserConverter converter;
	
	@MockBean
	private UserService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	void createUser() throws Exception {
		
		long id =1L;
		//User user =new User();
		User user =new User(id, "nameTest", "lastnameTest", "emailTes", "04/04/2023", "PasswordTest");
		//user.setId(id);
//		user.setName("nameTest");
//		user.setLastname("lastnameTest");
//		user.setMail("emailTest7");
//		user.setDate("04/04/2023");
//		user.setPassword("PasswordTest");
		
		when(service.addUser(user)).thenReturn(Optional.ofNullable(user));
		
		 mockMvc
		.perform(((MockHttpServletRequestBuilder) post("/user/add"))
				.content(objectMapper.writeValueAsString(user))	
				.contentType(MediaType.APPLICATION_JSON))							
		.andExpect(status().isOk());
	}


	
	

}
