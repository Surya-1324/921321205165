package com.example.afformed;


import lombok.Data;

@Data
public class Product {
    private String productName;
    private double price;
    private double rating;
    private int discount;
    private String availability;
}
