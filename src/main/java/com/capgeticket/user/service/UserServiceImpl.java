package com.capgeticket.user.service;

import com.capgeticket.user.model.User;
import com.capgeticket.user.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    /**
     * Introducir un nuevo usuario a la base de datos
     *
     * @param user : el usuario que se quiere introducir
     * @return el usuario que se introduce o vacio si ya existia
     */
    @Override
    public Optional<User> addUser(User user) {
        return repository.existsByMail(user.getMail()) ? Optional.empty() : Optional.of(repository.save(user));
    }
}
