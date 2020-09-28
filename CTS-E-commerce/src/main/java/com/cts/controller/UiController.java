package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cts.entity.*;
import com.cts.repository.*;

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
	public List<CtsCatalog> getCatalog() {
		return catalogRepository.findAll();
	}

	@GetMapping("/catalog/electronics")
	public List<CtsType> getElectronics() {
		return typeRepository.findByCatalogId("CTS-E");
	}

	@GetMapping("/catalog/fashion")
	public List<CtsType> getFashion() {
		return typeRepository.findByCatalogId("CTS-F");
	}

	@GetMapping("/catalog/homeAppliances")
	public List<CtsType> getHomeAppliances() {
		return typeRepository.findByCatalogId("CTS-H");
	}

	@GetMapping("/catalog/electronics/mobile")
	public List<CtsProduct> getTypeMobile() {
		return productRepository.findByTypeId("CTS-E/MOBILE");
	}

	@GetMapping("/catalog/electronics/laptop")
	public List<CtsProduct> getTypeLaptop() {
		return productRepository.findByTypeId("CTS-E/LAPTOP");
	}

	@GetMapping("/catalog/fashion/men")
	public List<CtsProduct> getTypemen() {
		return productRepository.findByTypeId("CTS-F/MEN");
	}

	@GetMapping("/catalog/fashion/women")
	public List<CtsProduct> getTypeWomen() {
		return productRepository.findByTypeId("CTS-F/WOMEN");
	}

	@GetMapping("/catalog/homeAppliances/furniture")
	public List<CtsProduct> getTypeFurniture() {
		return productRepository.findByTypeId("CTS-H/FURNITURE");
	}

	@GetMapping("/catalog/homeAppliances/decor")
	public List<CtsProduct> getTypeDecore() {
		return productRepository.findByTypeId("CTS-H/DECOR");
	}

	@PutMapping("/saveToCart")
	public void saveToCart(@RequestBody CtsCart userCart) {
		cartRepository.save(userCart);
	}
	
	@PostMapping("/viewCart")
	public List<CtsCart> viewCart(@RequestBody CtsUser userId) {
		return cartRepository.findByUserId(userId.getUserId());
	}

}
