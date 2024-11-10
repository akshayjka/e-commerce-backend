package com.example.E_Commerce.register.Entity.register;

import java.time.LocalDate;

// import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "productlist")
public class productList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price", nullable=false)
    private double price;

    @Column(name="images")
    private String images;

    @Column(name="manufacture_From")
    private String manufactureFrom;

    @Column(name="place_Of_Sale")
    private String placeOfSale;

    // @Temporal(TemporalType.DATE)
    @Column(name="date_Of_Manufactured")
    private LocalDate dateOfManufactured;

}