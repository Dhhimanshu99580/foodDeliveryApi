package com.foodDeliveryApi.foodDeliveryApi.models;

public class DeliveryRequest {
    private String zone;
    private String organizationId;
    private double totalDistance;
    private String itemType;

    public DeliveryRequest(String zone, String organizationId, double totalDistance, String itemType) {
        this.zone = zone;
        this.organizationId = organizationId;
        this.totalDistance = totalDistance;
        this.itemType = itemType;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

}
