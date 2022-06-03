package com.example.Eccomerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.Eccomerce.Model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{

}
