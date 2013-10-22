package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.domain.Productdescription;

@Repository
public  interface IProductDescription extends JpaRepository<Productdescription,String> {

}
