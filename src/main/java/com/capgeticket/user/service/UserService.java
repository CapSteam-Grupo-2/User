package com.capgeticket.user.service;

import com.capgeticket.user.model.User;
import java.util.Optional;

public interface UserService {
    Optional<User> addUser(User user);

}
