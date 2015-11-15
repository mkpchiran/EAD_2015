/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ead.myproj.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Key itemId;
    private String model;
    private Integer manufacture;
    private Float price;
    private Integer status;
    private String description;
    private String photo;
    private Integer capacity;
    private Integer fuel;
    private Integer cylinders;
    private Integer mounting;

    public Item() {
    }

    public Item(Key itemId) {
        this.itemId = itemId;
    }

    public Key getItemId() {
        return itemId;
    }

    public void setItemId(Key itemId) {
        this.itemId = itemId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufacture() {
        return manufacture;
    }

    public void setManufacture(Integer manufacture) {
        this.manufacture = manufacture;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public Integer getMounting() {
        return mounting;
    }

    public void setMounting(Integer mounting) {
        this.mounting = mounting;
    }

    @Override
    public String toString() {
        return "com.ead.myproj.entity.Item[ itemId=" + itemId + " ]";
    }
    
}
