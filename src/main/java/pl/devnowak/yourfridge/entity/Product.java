package pl.devnowak.yourfridge.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=2, message = "Size must be minimum 2!")
    private String name;

    @NotNull(message = "You must choose a date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOfPurchase;
    private ProductCategory category;
    private double price;
    private String shop;

    public Product() {
    }

    public Product(String name, LocalDate expirationDate, LocalDate dayOfPurchase,
                   ProductCategory category, double price, String shop) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.dayOfPurchase = dayOfPurchase;
        this.category = category;
        this.price = price;
        this.shop = shop;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getDayOfPurchase() {
        return dayOfPurchase;
    }

    public void setDayOfPurchase(LocalDate dayOfPurchase) {
        this.dayOfPurchase = dayOfPurchase;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

}