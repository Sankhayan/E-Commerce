package com.ecom.entity;

import javax.persistence.*;

@Entity
@Table(name = "ECOM_PRODUCT")
public class EcomProduct {

	@Id
	@Column(name = "Product_Id")
	private String productId;
	@Column(name = "Product_Name")
	private String productName;
	@Column(name = "Product_Price")
	private float productPrice;
	@Column(name = "Type_Id")
	private String typeId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "EcomProduct [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", typeId=" + typeId + "]";
	}

	public EcomProduct(String productId, String productName, float productPrice, String typeId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.typeId = typeId;
	}

	public EcomProduct() {
		super();
	}

}
