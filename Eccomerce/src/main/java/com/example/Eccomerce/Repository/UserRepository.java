package com.example.Eccomerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eccomerce.Model.Produto;
import com.example.Eccomerce.Model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);
}
