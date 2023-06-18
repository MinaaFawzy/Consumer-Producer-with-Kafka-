package com.example.project.SA2.springboot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Offer {

    private int id;
    private String description;
    private String product;
    private String operationType;

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", product='" + product + '\'' +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}
