package com.tgt.rysetii.learningresourcesapi.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="learningresources")
public class LearningResource {
    @Id
    @Column(name="learning_resource_id")
    private int id;
    @Column(name="learning_resource_name")
    private String productName;
    @Column(name="cost_price")
    private Double costPrice;
    @Column(name="selling_price")
    private Double sellingPrice;
    @Column(name="learning_resource_status")
    @Enumerated(EnumType.STRING)
    private LearningResourceStatus productStatus;
    @Column(name="created_date")
    private LocalDate createdDate;
    @Column(name="published_date")
    private LocalDate publishedDate;
    @Column(name="retired_date")
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



    @Override
    public String toString() {
        return "LearningResource{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", costPrice=" + costPrice +
                ", sellingPrice=" + sellingPrice +
                ", productStatus=" + productStatus +
                ", createdDate=" + createdDate +
                ", publishedDate=" + publishedDate +
                ", retiredDate=" + retiredDate +
                '}';
    }
}
