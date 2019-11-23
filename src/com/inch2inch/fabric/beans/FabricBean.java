package com.inch2inch.fabric.beans;

public class FabricBean {

    private int id;

    private String image_path;

    private String fabric_type;

    private double price;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getImage_path() {
	return image_path;
    }

    public void setImage_path(String image_path) {
	this.image_path = image_path;
    }

    public String getFabric_type() {
	return fabric_type;
    }

    public void setFabric_type(String fabric_type) {
	this.fabric_type = fabric_type;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    @Override
    public String toString() {
	return "FabricBean [id=" + id + ", image_path=" + image_path
		+ ", fabric_type=" + fabric_type + ", price=" + price + "]";
    }

}
