package com.cg.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cg.domain.Category;
import com.cg.domain.Product;
import com.cg.service.ProductService;
import com.cg.util.ImageProdId;

@Controller
public class ProductController {

@Autowired	
private ProductService prod_service;
	
@Value("#{albumResource['path']}")
private String albumpath;

@Value("#{albumResource['drive']}")
private String drive;

@RequestMapping("/")	
	public String productHome(HttpServletRequest request,ModelMap map){
		List<String> mediaPath=prod_service.getAlbumPath();
		List<String> images=new ArrayList<String>();
		List<String> productId=prod_service.getProductIds();
		System.out.println(mediaPath);
		StringBuffer url=request.getRequestURL();
		List<ImageProdId> image_prodId_map=new ArrayList<ImageProdId>();
		int i=0;
		for(String path:mediaPath){
			File folder=new File(drive+path);
			System.out.println(folder.isDirectory());
			File[] files=folder.listFiles();
			
			for(File f:files){
				ImageProdId img_prod=new ImageProdId();
				System.out.println(url+folder.getName()+"/"+f.getName());
				images.add(url+albumpath+folder.getName()+"/"+f.getName());
				img_prod.setImgPath(images.get(images.indexOf(url+albumpath+folder.getName()+"/"+f.getName())));
				img_prod.setProdId(productId.get(i));
				image_prodId_map.add(img_prod);
			}
			i++;
		}
		System.out.println(images);
/*		map.put("imageList",images);
		map.put("productIdList",productId);*/
		System.out.println(image_prodId_map);
		map.put("imageProdMap",image_prodId_map);
		return "productHome";
	}
@RequestMapping("/product")
	public String selectedProduct(HttpServletRequest request){
		String selectedProductTags=prod_service.getTags(request.getParameter("prodId"));
		String [] tagList=selectedProductTags.split(",");
		Category category=prod_service.getCategory(request.getParameter("prodId"));
		System.out.println(category.getCategoryId());
		List<Product> prod_list=prod_service.getProductsByCategory(category);
		System.out.println(prod_list.size());
		Product p=prod_list.get(0);
		System.out.println(p.getMedias().get(0).getMediaPath());
		return "product";
	}
}
