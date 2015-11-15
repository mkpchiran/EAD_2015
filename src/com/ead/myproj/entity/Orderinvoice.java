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
public class Orderinvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Key orderId;
    private Key itemId;
    private String quantity;
    private String date;
    private String status;
    private Key orderBy;
    private Key acceptBy;
    private Integer price;

    public Orderinvoice() {
    }

    public Orderinvoice(Key orderId) {
        this.orderId = orderId;
    }

    public Key getOrderId() {
        return orderId;
    }

    public void setOrderId(Key orderId) {
        this.orderId = orderId;
    }

    public Key getItemId() {
        return itemId;
    }

    public void setItemId(Key itemId) {
        this.itemId = itemId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Key getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Key orderBy) {
        this.orderBy = orderBy;
    }

    public Key getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(Key acceptBy) {
        this.acceptBy = acceptBy;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "com.ead.myproj.entity.Orderinvoice[ orderId=" + orderId + " ]";
    }
    
}
