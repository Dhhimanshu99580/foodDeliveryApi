package com.foodDeliveryApi.foodDeliveryApi.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="organization_id",nullable=false)
    private Organization organization;
    @Setter
    @ManyToOne
    @JoinColumn(name="item_id",nullable=false)
    private Item item;
    @Setter
    private String zone;
    private double base_distance_in_km;
    private final double km_price = 1.5;
    private final int fix_price = 10;

    public void setId(int id) {
        this.id = id;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Pricing{" +
                "id=" + id +
                ", organization=" + organization +
                ", item=" + item +
                ", zone='" + zone + '\'' +
                ", base_distance_in_km=" + base_distance_in_km +
                ", km_price=" + km_price +
                ", fix_price=" + fix_price +
                '}';
    }
}
