package com.cg.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String productId;
	private String merchantId;
	private String productBrand;
	private float productCost;
	private Date productCreationdate;
	private String productName;
	private Date productSolddate;
	private String productTag;
	private List<Media> medias;
	private Category category;
	private List<Productdescription> productdescriptions;

	public Product() {
	}


	@Id
	@Column(name="product_id")
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}


	@Column(name="merchant_id")
	public String getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	@Column(name="product_brand")
	public String getProductBrand() {
		return this.productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}


	@Column(name="product_cost")
	public float getProductCost() {
		return this.productCost;
	}

	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="product_creationdate")
	public Date getProductCreationdate() {
		return this.productCreationdate;
	}

	public void setProductCreationdate(Date productCreationdate) {
		this.productCreationdate = productCreationdate;
	}


	@Column(name="product_name")
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="product_solddate")
	public Date getProductSolddate() {
		return this.productSolddate;
	}

	public void setProductSolddate(Date productSolddate) {
		this.productSolddate = productSolddate;
	}


	@Column(name="product_tag")
	public String getProductTag() {
		return this.productTag;
	}

	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}


	//bi-directional many-to-one association to Media
	@OneToMany(mappedBy="product")
	public List<Media> getMedias() {
		return this.medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public Media addMedia(Media media) {
		getMedias().add(media);
		media.setProduct(this);

		return media;
	}

	public Media removeMedia(Media media) {
		getMedias().remove(media);
		media.setProduct(null);

		return media;
	}


	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//bi-directional many-to-one association to Productdescription
	@OneToMany(mappedBy="product")
	public List<Productdescription> getProductdescriptions() {
		return this.productdescriptions;
	}

	public void setProductdescriptions(List<Productdescription> productdescriptions) {
		this.productdescriptions = productdescriptions;
	}

	public Productdescription addProductdescription(Productdescription productdescription) {
		getProductdescriptions().add(productdescription);
		productdescription.setProduct(this);

		return productdescription;
	}

	public Productdescription removeProductdescription(Productdescription productdescription) {
		getProductdescriptions().remove(productdescription);
		productdescription.setProduct(null);

		return productdescription;
	}

}