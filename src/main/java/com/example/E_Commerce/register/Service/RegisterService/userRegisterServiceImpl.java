package com.example.E_Commerce.register.Service.RegisterService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_Commerce.register.Entity.productRequest;
import com.example.E_Commerce.register.Entity.register.productList;
import com.example.E_Commerce.register.Entity.register.userRegister;
import com.example.E_Commerce.register.Repository.productRepository;
import com.example.E_Commerce.register.Repository.registeredUser;

@Service
public class userRegisterServiceImpl implements userRegisterService{


    @Autowired
private final registeredUser users = null;

@Autowired
private final productRepository productRepo = null;

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

    @Override
    public Optional<userRegister> authenticateUser(String email, String password) {
        Optional<userRegister> user = Optional.ofNullable(users.findByEmail(email));
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty(); // Return empty if the user doesn't exist or password doesn't match
    }

    @Override
    public String getNameByEmail(String email) {
        userRegister userEmail = users.findByEmail(email);
        return userEmail != null? userEmail.getName() : null ;
        // return userEmail.map(userRegister::getName).orElse(null);
    }

    @Override
    public List<productList> getProductList() {
        return productRepo.findAll();
    }

    @Override
    public productList saveProduct(productRequest productRequest) {
        productList product = new productList();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setImages(productRequest.getImages());
        product.setManufactureFrom(productRequest.getManufactureFrom());
        product.setPlaceOfSale(productRequest.getPlaceOfSale());
        product.setDateOfManufactured(productRequest.getDateOfManufactured());
        
        return productRepo.save(product);
    }

}
