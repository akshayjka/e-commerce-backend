package com.example.E_Commerce.register.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_Commerce.register.Entity.register.userRegister;
import com.example.E_Commerce.register.Repository.loginDTO;
import com.example.E_Commerce.register.Service.RegisterService.userRegisterService;
import com.example.E_Commerce.register.response.ResponseDTO;
import com.example.E_Commerce.register.security.jwtUtili;

@RestController
@RequestMapping("/login")
public class userLoginController {

    @Autowired
    private userRegisterService userRegisterService;

    @Autowired
    private jwtUtili jwtUtil;  // Use the injected instance here
    
    @PostMapping("/user")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody loginDTO loginDTO) {
        Optional<userRegister> user = userRegisterService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());
        
      if (user.isPresent()) {
        // Success response
        String token = jwtUtil.generateToken(loginDTO.getEmail());

        // Success response with token
        ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK.value(), "Login successful!", token);
        return ResponseEntity.ok(responseDTO);
    } else {
      // Unauthorized response
      ResponseDTO responseDTO = new ResponseDTO(HttpStatus.UNAUTHORIZED.value(), "Invalid email or password!", null);
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
    }
    }
    
}
