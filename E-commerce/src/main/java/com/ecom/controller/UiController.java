package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecom.entity.*;
import com.ecom.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/E-Commerce/*")
public class UiController {

	@Autowired
	private CatalogRepository catalogRepository;
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;

	@GetMapping("/catalog")
	public List<EcomCatalog> getCatalog() {
		return catalogRepository.findAll();
	}

	@GetMapping("/catalog/electronics")
	public List<EcomType> getElectronics() {
		return typeRepository.findByCatalogId("ECOM-E");
	}

	@GetMapping("/catalog/fashion")
	public List<EcomType> getFashion() {
		return typeRepository.findByCatalogId("ECOM-F");
	}

	@GetMapping("/catalog/homeAppliances")
	public List<EcomType> getHomeAppliances() {
		return typeRepository.findByCatalogId("ECOM-H");
	}

	@GetMapping("/catalog/electronics/mobile")
	public List<EcomProduct> getTypeMobile() {
		return productRepository.findByTypeId("ECOM-E/MOBILE");
	}

	@GetMapping("/catalog/electronics/laptop")
	public List<EcomProduct> getTypeLaptop() {
		return productRepository.findByTypeId("ECOM-E/LAPTOP");
	}

	@GetMapping("/catalog/fashion/men")
	public List<EcomProduct> getTypeMen() {
		return productRepository.findByTypeId("ECOM-F/MEN");
	}

	@GetMapping("/catalog/fashion/women")
	public List<EcomProduct> getTypeWomen() {
		return productRepository.findByTypeId("ECOM-F/WOMEN");
	}

	@GetMapping("/catalog/homeAppliances/furniture")
	public List<EcomProduct> getTypeFurniture() {
		return productRepository.findByTypeId("ECOM-H/FURNITURE");
	}

	@GetMapping("/catalog/homeAppliances/decor")
	public List<EcomProduct> getTypeDecore() {
		return productRepository.findByTypeId("ECOM-H/DECOR");
	}

	@PutMapping("/saveToCart")
	public String saveToCart(@RequestBody EcomCart userCart) {
		cartRepository.save(userCart);
		return "Added To Cart";
	}

	@PostMapping("/viewCart")
	public List<EcomCart> viewCart(@RequestBody EcomUser userId) {
		return cartRepository.findByUserId(userId.getUserId());
	}
}
