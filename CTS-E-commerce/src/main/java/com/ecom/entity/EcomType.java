package com.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECOM_TYPE")
public class EcomType {

	@Id
	@Column(name = "Type_Id")
	private String typeId;
	@Column(name = "Type_Name")
	private String typeName;
	@Column(name = "Catalog_Id")
	private String catalogId;

	public EcomType() {
	}

	public EcomType(String typeId, String typeName, String catalogId) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.catalogId = catalogId;
	}

	@Override
	public String toString() {
		return "EcomType [typeId=" + typeId + ", typeName=" + typeName + ", catalog_id=" + catalogId + "]";
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void getTypeName(String typeName) {
		this.typeName = typeName;
	}

}
