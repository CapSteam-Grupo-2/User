package com.capgeticket.user.service;

import com.capgeticket.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	
    Optional<User> addUser(User user);
    
    List<User> getUsers();
    
    Optional<User> deletebyId(long id);
    
    Optional<User> findById(long id);
    
    Optional<User> updateUser(User user);
    
    
    

}
