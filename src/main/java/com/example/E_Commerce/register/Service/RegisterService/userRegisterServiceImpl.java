package com.example.E_Commerce.register.Service.RegisterService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_Commerce.register.Entity.register.userRegister;
import com.example.E_Commerce.register.Repository.registeredUser;

@Service
public class userRegisterServiceImpl implements userRegisterService{


    @Autowired
private final registeredUser users = null;

    @Override
    public List<userRegister> getAllUser() {
       return users.findAll();
    }

    @Override
    public Optional<userRegister> getUserById(int id) {
      return users.findById(id);
    }

    @Override
    public userRegister saveUser(userRegister user) {
        return users.save(user);
    }

    @Override
    public Optional<userRegister> getUserByEmail(String email) {
        return Optional.ofNullable(users.findByEmail(email));
    }

    @Override
    public void deleteUser(int id) {
        users.deleteById(id);
    }

}
