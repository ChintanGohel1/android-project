package com.inch2inch.customer.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable {

    private static final long serialVersionUID = 1059628845051023034L;

    public CustomerBean() {
	super();
    }

    public CustomerBean(String name, String email, String mobile,
	    String address, double chest, double neck, double waist,
	    double pant_length, double sleave_length, double shirt_length) {
	this();
	this.name = name;
	this.email = email;
	this.mobile = mobile;
	this.address = address;
	this.chest = chest;
	this.neck = neck;
	this.waist = waist;
	this.pant_length = pant_length;
	this.sleave_length = sleave_length;
	this.shirt_length = shirt_length;
    }

    private int id;

    private String name;

    private String email;

    private String mobile;

    private String address;

    private double chest;

    private double neck;

    private double waist;

    private double pant_length;

    private double sleave_length;

    private double shirt_length;

    public int retriveCustomerId(){
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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public double getChest() {
	return chest;
    }

    public void setChest(double chest) {
	this.chest = chest;
    }

    public double getNeck() {
	return neck;
    }

    public void setNeck(double neck) {
	this.neck = neck;
    }

    public double getWaist() {
	return waist;
    }

    public void setWaist(double waist) {
	this.waist = waist;
    }

    public double getPant_length() {
	return pant_length;
    }

    public void setPant_length(double pant_length) {
	this.pant_length = pant_length;
    }

    public double getSleave_length() {
	return sleave_length;
    }

    public void setSleave_length(double sleave_length) {
	this.sleave_length = sleave_length;
    }

    public double getShirt_length() {
	return shirt_length;
    }

    public void setShirt_length(double shirt_length) {
	this.shirt_length = shirt_length;
    }

    @Override
    public String toString() {
	return "CustomerBean [id=" + id + ", name=" + name + ", email=" + email
		+ ", mobile=" + mobile + ", address=" + address + ", chest="
		+ chest + ", neck=" + neck + ", waist=" + waist
		+ ", pant_length=" + pant_length + ", sleave_length="
		+ sleave_length + ", shirt_length=" + shirt_length + "]";
    }

}
