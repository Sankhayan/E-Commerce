package com.ecom.entity;

import javax.persistence.*;

@Entity
@Table(name = "ECOM_CART")
public class EcomCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cart_Id")
	private long cartId;
	@Column(name = "User_Id")
	private String userId;
	@Column(name = "Product_Name")
	private String productName;
	@Column(name = "Product_Price")
	private float productPrice;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public EcomCart() {
		super();
	}

	public EcomCart(String userId, String productName, float productPrice) {
		super();
		this.userId = userId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "EcomCart [userId=" + userId + ", productName=" + productName + ", productPrice=" + productPrice + "]";
	}

	

}
