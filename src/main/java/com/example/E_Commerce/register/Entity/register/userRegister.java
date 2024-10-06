package com.example.E_Commerce.register.Entity.register;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "register_user")
public class userRegister {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="name", nullable=false, length = 30)
private String name;

@Column(name = "email", nullable = false, length = 30, unique = true )
private String email;

@Column(name = "password", nullable = false, length = 255)
private String password;

@Column(name = "dob")
private LocalDate dob;

@Column(name = "gender", nullable = false)
private String gender;

@Column(name = "street", length = 30)
private String street;

@Column(name = "area", length = 50)
private String area;

@Column(name = "city", length = 30)
private String city;

@Column(name = "state", length = 30)
private String state;

@Column(name = "postal_code", length = 30)
private String postal_code;

@Column(name = "mobile_number", nullable = false, length = 15)
private String mobile_number;

}
