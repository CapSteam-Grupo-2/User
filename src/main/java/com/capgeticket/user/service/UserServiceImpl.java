package com.capgeticket.user.service;

import com.capgeticket.user.model.User;
import com.capgeticket.user.repository.UserRepository;

import java.util.List;
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
        return repository.existsByMail(user.getEmail()) ? Optional.empty() : Optional.of(repository.save(user));
    }

	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public Optional<User> deletebyId(long id) {
		Optional<User> user= findById(id);
		if(user.isPresent()) {
			repository.deleteById(id);
		}
		return user;
	}

	@Override
	public Optional<User> findById(long id) {		
		return repository.findById(id);
	}

	@Override
	public Optional<User> updateUser(User user) {
		if (user!=null) {
			repository.save(user);
		}		
		return repository.findById(user.getId());
	}
    
    
}
