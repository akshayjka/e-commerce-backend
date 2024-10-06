package com.example.E_Commerce.register.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.E_Commerce.register.Entity.register.userRegister;


@Repository
public interface registeredUser extends JpaRepository<userRegister, Integer>{
    userRegister findByEmail(String email);
}
