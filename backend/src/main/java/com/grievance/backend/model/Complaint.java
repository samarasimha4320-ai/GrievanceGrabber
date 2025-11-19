 package com.grievance.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String consumerName;
    private String title;

    @Column(length = 1000)
    private String description;

    private String product;
    private String company;
    private String status; // OPEN / IN_PROGRESS / RESOLVED

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Complaint() {
        this.createdAt = LocalDateTime.now();
        this.status = "OPEN";
    }

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getConsumerName() { return consumerName; }
    public void setConsumerName(String consumerName) { this.consumerName = consumerName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
