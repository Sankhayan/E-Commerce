package com.ecom.entity;

import javax.persistence.*;

@Entity
@Table(name = "ECOM_CATALOG")
public class EcomCatalog {

	@Id
	@Column(name = "Catalog_Id")
	private String catalogId;
	@Column(name = "Catalog_Name")
	private String catalogName;

	public EcomCatalog() {
	}

	public EcomCatalog(String catalogId, String catalogName) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
	}

	@Override
	public String toString() {
		return "EcomCatalog [catalogId=" + catalogId + ", catalogName=" + catalogName + "]";
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

}
