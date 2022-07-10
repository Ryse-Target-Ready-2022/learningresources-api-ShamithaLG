package com.tgt.rysetii.learningresourcesapi.entity;

import java.time.LocalDate;

public class LearningResource {
    private int id;
    private String productName;
    private Double costPrice;
    private Double sellingPrice;
    private LearningResourceStatus productStatus;
    private LocalDate createdDate;
    private LocalDate publishedDate;
    private LocalDate retiredDate;

    public LearningResource(int id, String productName, Double costPrice, Double sellingPrice, LearningResourceStatus productStatus, LocalDate createdDate, LocalDate publishedDate, LocalDate retiredDate) {
        this.id = id;
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productStatus = productStatus;
        this.createdDate = createdDate;
        this.publishedDate = publishedDate;
        this.retiredDate = retiredDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setProductStatus(LearningResourceStatus productStatus) {
        this.productStatus = productStatus;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setRetiredDate(LocalDate retiredDate) {
        this.retiredDate = retiredDate;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public LearningResourceStatus getProductStatus() {
        return productStatus;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public LocalDate getRetiredDate() {
        return retiredDate;
    }
}
