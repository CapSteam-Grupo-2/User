package com.capgeticket.user.repository;

import com.capgeticket.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
