package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.Category;
import com.cg.domain.Product;

@Repository
public interface IProduct extends JpaRepository<Product,String>{

@Transactional
@Query("select p.productId from Product p")
	List<String> getProductIds();

@Transactional
@Query("select p.productTag from Product p where p.productId=?1")
String findProductTagByProductId(String productId);
@Transactional
@Query("select p.category from Product p where p.productId=?1")
Category findCategoryId(String prodId);

@Transactional
List<Product> findByCategory(Category category);

}
