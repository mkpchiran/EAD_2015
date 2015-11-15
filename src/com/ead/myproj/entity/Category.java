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
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Key categoryId;
    private String capacity;
    private String fuel;
    private String cylinders;
    private String mounting;

    public Category() {
    }

    public Category(Key categoryId) {
        this.categoryId = categoryId;
    }

    public Key getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Key categoryId) {
        this.categoryId = categoryId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getCylinders() {
        return cylinders;
    }

    public void setCylinders(String cylinders) {
        this.cylinders = cylinders;
    }

    public String getMounting() {
        return mounting;
    }

    public void setMounting(String mounting) {
        this.mounting = mounting;
    }


    @Override
    public String toString() {
        return "com.ead.myproj.entity.Category[ categoryId=" + categoryId + " ]";
    }
    
}
