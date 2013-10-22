package com.cg.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productdescription database table.
 * 
 */
@Entity
public class Productdescription implements Serializable {
	private static final long serialVersionUID = 1L;
	private String descId;
	private String attributeName;
	private String attributeValue;
	private Product product;

	public Productdescription() {
	}


	@Id
	@Column(name="desc_id")
	public String getDescId() {
		return this.descId;
	}

	public void setDescId(String descId) {
		this.descId = descId;
	}


	@Column(name="attribute_name")
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}


	@Column(name="attribute_value")
	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}


	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}