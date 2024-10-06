package com.example.E_Commerce.register.Service.RegisterService;

import java.util.List;
import java.util.Optional;

import com.example.E_Commerce.register.Entity.register.userRegister;

public interface userRegisterService {
    public List<userRegister> getAllUser();

    public Optional<userRegister> getUserById(int id);

    public userRegister saveUser(userRegister user);

   public Optional<userRegister> getUserByEmail(String email);

   public void deleteUser(int id);
    
}
