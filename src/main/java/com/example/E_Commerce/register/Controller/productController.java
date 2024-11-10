package com.example.E_Commerce.register.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_Commerce.register.Entity.productRequest;
import com.example.E_Commerce.register.Entity.register.productList;
import com.example.E_Commerce.register.Service.RegisterService.userRegisterService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200") 
public class productController {

    @Autowired
    private userRegisterService userRegisterService;

    //    @GetMapping("/productList")
    // public List<productList> getAllProducts() {
    //     return userRegisterService.getProductList();
    // }

    @GetMapping("/productList")
     public ResponseEntity<List<productList>> getAllProducts(@RequestHeader("Authorization") String authHeader) {
        List<productList> products = userRegisterService.getProductList();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/productList")
    public ResponseEntity<?> addProduct(@RequestBody productRequest productRequest) {
        productList saveProduct = userRegisterService.saveProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Product added successfully with ID: " + saveProduct.getProductId());
    }

    
}
