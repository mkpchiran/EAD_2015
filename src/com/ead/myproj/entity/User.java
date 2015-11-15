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
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Key userId;
    private String username;
    private String password;
    private String email;
    private String address;
    private String fullname;
    private String status;
    private String phone;

    public User() {
    }

    public User(Key userId) {
        this.userId = userId;
    }

    public User(String fullname, String username, String password,
			String email, String address, String phone, String status) {
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone  = phone;
		this.address = address;
		this.status = status;
	}

	public Key getUserId() {
        return userId;
    }

    public void setUserId(Key userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "com.ead.myproj.entity.User[ userId=" + userId + " ]";
    }
    
}
