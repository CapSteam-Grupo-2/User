package com.capgeticket.user.converter;

import java.util.List;
import java.util.stream.Collectors;


import com.capgeticket.user.model.User;
import com.capgeticket.user.response.UserResponse;

/*
 * Se utiliza para convertir de entity a DTO
 */
public class UserConverter {

	public UserResponse of(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setName(user.getName());
		userResponse.setLastname(user.getLastname());
		userResponse.setMail(user.getMail());
		userResponse.setDate(user.getDate());
		userResponse.setPassword(user.getPassword());
		return userResponse;
	}
	
    public List<UserResponse> of(List<User> users) {
        return users.stream()
                .map(p -> of(p))
                .collect(Collectors.toList());
    }

}
