package com.capgeticket.user.controller;

import com.capgeticket.user.converter.UserConverter;
import com.capgeticket.user.errors.BadRequestException;
import com.capgeticket.user.model.User;
import com.capgeticket.user.response.UserResponse;
import com.capgeticket.user.service.UserService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	/**
	 * Guarda un nuevo usuario, validando que los datos que se introducen no están
	 * vacios o null
	 *
	 * @param user usuario que se quiere guardar, validando no esta vacio o null
	 * @return un ResponseEntity con el usuario que se ha guardado o error si algo
	 *         fue mal
	 */
	@PostMapping(path = { "/add" })
	public ResponseEntity<UserResponse> addUser(@Valid @RequestBody User user) {
		Optional<User> response = service.addUser(user);
		if (response.isEmpty()) {
			throw new BadRequestException(user.getMail());
		}
		return ResponseEntity.ok(converter.of(response.get()));
	}

	/**
	 *
	 *
	 * @param
	 * @return
	 */
	@GetMapping
	public List<UserResponse> getUsers() {
		return converter.of(service.getUsers());
	}

	/**
	 *
	 *
	 * @param
	 * @return
	 */
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<UserResponse> findById(@PathVariable("id") long id) {
		Optional<User> response = service.findById(id);
		if (response.isEmpty()) {
			throw new RuntimeException("No existe usuario para el id: " + id);
		}
		return ResponseEntity.ok(converter.of(response.get()));
	}

	/**
	 * 
	 *
	 * @param
	 * @return
	 */
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<UserResponse> deleteById(@PathVariable("id") long id) {
		Optional<User> response = service.deletebyId(id);
		if (response.isEmpty()) {
			throw new RuntimeException("No existe usuario para el id: " + id);
		}
		return ResponseEntity.ok(converter.of(response.get()));
	}

	/**
	 * 
	 *
	 * @param
	 * @return
	 */
	@PutMapping(path = { "/{id}" })
	public ResponseEntity<UserResponse> Update(@PathVariable("id") long id) {

		Optional<User> response = service.findById(id);
		if (response.isEmpty()) {
			throw new RuntimeException("No existe usuario para el id: " + id);
		}
		service.updateUser(response.get());

		return ResponseEntity.ok(converter.of(response.get()));
	}

}
