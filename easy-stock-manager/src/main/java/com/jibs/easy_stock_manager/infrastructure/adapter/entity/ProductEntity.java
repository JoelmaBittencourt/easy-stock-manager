package com.jibs.easy_stock_manager.infrastructure.adapter.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int usedQuantity;

    String marca;

    private String description;

    private int reviewStars;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "store_name")
    private String storeName;

    private String category;
    private String additionalInfo;
    private boolean open;

    @Column(name = "sub_category")
    private String subCategory;

    private String room;

    @Column(name = "specific_location")
   private  String specificLocation;


    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, BigDecimal price, int quantity, int usedQuantity, String marca, String description, int reviewStars, LocalDate purchaseDate, LocalDate expiryDate, String storeName, String category, String additionalInfo, boolean open, String subCategory, String room, String specificLocation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.usedQuantity = usedQuantity;
        this.marca = marca;
        this.description = description;
        this.reviewStars = reviewStars;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.storeName = storeName;
        this.category = category;
        this.additionalInfo = additionalInfo;
        this.open = open;
        this.subCategory = subCategory;
        this.room = room;
        this.specificLocation = specificLocation;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSpecificLocation() {
        return specificLocation;
    }

    public void setSpecificLocation(String specificLocation) {
        this.specificLocation = specificLocation;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public String getSubCategory() {
        return subCategory;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUsedQuantity() {
        return usedQuantity;
    }

    public void setUsedQuantity(int usedQuantity) {
        this.usedQuantity = usedQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(int reviewStars) {
        this.reviewStars = reviewStars;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
