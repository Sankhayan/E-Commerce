package com.cts.entity;

import javax.persistence.*;

@Entity
public class CtsCatalog {

	@Id
	@Column(name = "Catalog_Id")
	private String catalogId;
	@Column(name = "Catalog_Name")
	private String catalogName;

	public CtsCatalog() {
	}

	public CtsCatalog(String catalogId, String catalogName) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
	}

	@Override
	public String toString() {
		return "CtsCatalog [catalogId=" + catalogId + ", catalogName=" + catalogName + "]";
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
