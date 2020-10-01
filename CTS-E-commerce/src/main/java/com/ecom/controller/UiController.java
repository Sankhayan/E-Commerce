package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecom.entity.*;
import com.ecom.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/CTS-E-Commerce/*")
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
		return typeRepository.findByCatalogId("CTS-E");
	}

	@GetMapping("/catalog/fashion")
	public List<EcomType> getFashion() {
		return typeRepository.findByCatalogId("CTS-F");
	}

	@GetMapping("/catalog/homeAppliances")
	public List<EcomType> getHomeAppliances() {
		return typeRepository.findByCatalogId("CTS-H");
	}

	@GetMapping("/catalog/electronics/mobile")
	public List<EcomProduct> getTypeMobile() {
		return productRepository.findByTypeId("CTS-E/MOBILE");
	}

	@GetMapping("/catalog/electronics/laptop")
	public List<EcomProduct> getTypeLaptop() {
		return productRepository.findByTypeId("CTS-E/LAPTOP");
	}

	@GetMapping("/catalog/fashion/men")
	public List<EcomProduct> getTypemen() {
		return productRepository.findByTypeId("CTS-F/MEN");
	}

	@GetMapping("/catalog/fashion/women")
	public List<EcomProduct> getTypeWomen() {
		return productRepository.findByTypeId("CTS-F/WOMEN");
	}

	@GetMapping("/catalog/homeAppliances/furniture")
	public List<EcomProduct> getTypeFurniture() {
		return productRepository.findByTypeId("CTS-H/FURNITURE");
	}

	@GetMapping("/catalog/homeAppliances/decor")
	public List<EcomProduct> getTypeDecore() {
		return productRepository.findByTypeId("CTS-H/DECOR");
	}

	@PutMapping("/saveToCart")
	public void saveToCart(@RequestBody EcomCart userCart) {
		cartRepository.save(userCart);
	}
	
	@PostMapping("/viewCart")
	public List<EcomCart> viewCart(@RequestBody EcomUser userId) {
		return cartRepository.findByUserId(userId.getUserId());
	}

}
