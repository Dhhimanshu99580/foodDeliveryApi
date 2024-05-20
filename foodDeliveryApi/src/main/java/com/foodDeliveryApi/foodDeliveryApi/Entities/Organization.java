
package com.foodDeliveryApi.foodDeliveryApi.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "organization")
    private List<Pricing> pricing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}