package com.example.project.SA2.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name = "offers")
public class OfferDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id")
    private int id;

    @Column(name = "Description")
    private String description;

    @Column(name = "Product")
    private String product;

    @Override
    public String toString() {
        return "OfferDb{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
