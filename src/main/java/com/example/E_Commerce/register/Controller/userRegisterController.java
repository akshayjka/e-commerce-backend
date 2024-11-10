package com.example.E_Commerce.register.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_Commerce.register.Entity.register.userRegister;
import com.example.E_Commerce.register.Service.RegisterService.userRegisterService;
import com.example.E_Commerce.register.security.jwtUtili;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class userRegisterController {

    @Autowired
    private userRegisterService userRegisterService;

    @Autowired
    private jwtUtili jwtUtili;

    @GetMapping("/user")
    public List<userRegister>getAllUser(){
        List<userRegister> users = userRegisterService.getAllUser();
        return users;
    }

    @PostMapping("/user")
    public userRegister createUser(@RequestBody userRegister userData) {
        userRegister user = userRegisterService.saveUser(userData);
        return user;
    }

    @GetMapping("/get-name") 
    public ResponseEntity getName(@RequestParam String email, @RequestHeader(value="Authorization") String authorizationHeader) throws Exception {
        System.out.println("Generated token after encryting  : : : "+authorizationHeader + email);

            // Check if token is expired
    // if (jwtUtili.isTokenExpired(authorizationHeader)) {
    //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token has expired");
    // }
        // String authorize = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrZXZpbkBnbWFpbC5jb20iLCJpYXQiOjE3MzA2MzcxNDQsImV4cCI6MTczMDYzNzE2MiwiYXVkIjoia2V2aW5AZ21haWwuY29tIn0.iqlv7Pm_Sd3DemysESrOuPLhLrX0ihxGjNVOKD5MKJE";
        jwtUtili.verify(authorizationHeader,email);
        // jwtUtili.validateToken(auth, email);
        // return userRegisterService.getNameByEmail(email);
        return ResponseEntity.ok(userRegisterService.getNameByEmail(email));
    }

}
