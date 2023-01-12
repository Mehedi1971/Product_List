package com.mahedi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productlist")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String productImage;
	private String productName;
	private String productDescription;
	private String Price;
	private String Qunatity;

	public Product() {
		super();
	}

	public Product(long id, String productImage, String productName, String productDescription, String price,
			String qunatity) {
		super();
		this.id = id;
		this.productImage = productImage;
		this.productName = productName;
		this.productDescription = productDescription;
		Price = price;
		Qunatity = qunatity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getQunatity() {
		return Qunatity;
	}

	public void setQunatity(String qunatity) {
		Qunatity = qunatity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productImage=" + productImage + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", Price=" + Price + ", Qunatity=" + Qunatity + "]";
	}

}
