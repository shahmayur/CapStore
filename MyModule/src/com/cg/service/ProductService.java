package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.domain.Category;
import com.cg.domain.Product;
import com.cg.repository.ICategory;
import com.cg.repository.IMedia;
import com.cg.repository.IProduct;
import com.cg.repository.IProductDescription;

@Service
public class ProductService {
	@Autowired
	private ICategory icat;

	@Autowired
	private IMedia imed;

	@Autowired
	private IProduct iprod;

	@Autowired
	private IProductDescription iprodDesc;
	
	public List<String> getAlbumPath(){
		return imed.getMediaPath();
	}

	public List<String> getProductIds() {
		// TODO Auto-generated method stub
		
		return iprod.getProductIds();
	}

	public String getTags(String prodId) {
		// TODO Auto-generated method stub
		
		return iprod.findProductTagByProductId(prodId);
	}

	public List<Product> getProductsByCategory(Category category) {
		// TODO Auto-generated method stub
		return iprod.findByCategory(category);
	}

	public Category getCategory(String prodId) {
		// TODO Auto-generated method stub
		return iprod.findCategoryId(prodId);
	}
}
