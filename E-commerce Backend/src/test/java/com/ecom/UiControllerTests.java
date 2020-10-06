package com.ecom;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.ecom.controller.UiController;
import com.ecom.entity.*;
import com.ecom.repository.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UiControllerTests {

	@InjectMocks
	private UiController uiController;

	@Mock
	private CatalogRepository catalogRepository;

	@Mock
	private TypeRepository typeRepository;

	@Mock
	private ProductRepository productRepository;

	@Mock
	private CartRepository cartRepository;
	
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCatalogTest() throws Exception {
		when(catalogRepository.findAll())
				.thenReturn(Stream.of(new EcomCatalog("ECOM-E", "Electronics"), new EcomCatalog("ECOM-F", "Fashion"),
						new EcomCatalog("ECOM-H", "Home Appliances")).collect(Collectors.toList()));
		assertEquals(
				"[EcomCatalog [catalogId=ECOM-E, catalogName=Electronics], EcomCatalog [catalogId=ECOM-F, catalogName=Fashion], EcomCatalog [catalogId=ECOM-H, catalogName=Home Appliances]]",
				uiController.getCatalog().toString());
	}

	@Test
	public void getElectronicsTest() {
		EcomType obj = new EcomType("ECOM-E/MOBILE", "Mobile", "ECOM-E");
		List<EcomType> typeList = new ArrayList<EcomType>();
		typeList.add(obj);
		when(typeRepository.findByCatalogId("ECOM-E")).thenReturn(typeList);
		assertEquals(typeList, uiController.getElectronics());
	}
	
	@Test
	public void getFashionTest() {
		EcomType obj = new EcomType("ECOM-F/MEN", "Men", "ECOM-F");
		List<EcomType> typeList = new ArrayList<EcomType>();
		typeList.add(obj);
		when(typeRepository.findByCatalogId("ECOM-F")).thenReturn(typeList);
		assertEquals(typeList, uiController.getFashion());
	}
	
	@Test
	public void getHomeAppliancesTest() {
		EcomType obj = new EcomType("ECOM-H/FURNITURE", "Furniture", "ECOM-H");
		List<EcomType> typeList = new ArrayList<EcomType>();
		typeList.add(obj);
		when(typeRepository.findByCatalogId("ECOM-H")).thenReturn(typeList);
		assertEquals(typeList, uiController.getHomeAppliances());
	}
	
	@Test
	public void getTypeMobileTest() {
		EcomProduct obj = new EcomProduct("ECOM-E/MOBILE-001", "iPhone SE 2020", 36000, "ECOM-E/MOBILE");
		List<EcomProduct> typeList = new ArrayList<EcomProduct>();
		typeList.add(obj);
		when(productRepository.findByTypeId("ECOM-E/MOBILE")).thenReturn(typeList);
		assertEquals(typeList, uiController.getTypeMobile());
	}
	
	@Test
	public void getTypeLaptopTest() {
		EcomProduct obj = new EcomProduct("ECOM-E/LAPTOP-001", "MAC Book", 100000, "ECOM-E/LAPTOP");
		List<EcomProduct> typeList = new ArrayList<EcomProduct>();
		typeList.add(obj);
		when(productRepository.findByTypeId("ECOM-E/LAPTOP")).thenReturn(typeList);
		assertEquals(typeList, uiController.getTypeLaptop());
	}
	
	@Test
	public void getTypeMenTest() {
		EcomProduct obj = new EcomProduct("ECOM-F/MEN-001", "Shirts", 1000, "ECOM-F/MEN");
		List<EcomProduct> typeList = new ArrayList<EcomProduct>();
		typeList.add(obj);
		when(productRepository.findByTypeId("ECOM-F/MEN")).thenReturn(typeList);
		assertEquals(typeList, uiController.getTypeMen());
	}
	
	@Test
	public void getTypeWomenTest() {
		EcomProduct obj = new EcomProduct("ECOM-F/WOMEN-001", "Saree", 1000, "ECOM-F/WOMEN");
		List<EcomProduct> typeList = new ArrayList<EcomProduct>();
		typeList.add(obj);
		when(productRepository.findByTypeId("ECOM-F/WOMEN")).thenReturn(typeList);
		assertEquals(typeList, uiController.getTypeWomen());
	}
	
	@Test
	public void getTypeFurnitureTest() {
		EcomProduct obj = new EcomProduct("ECOM-H/FURNITURE-001", "Almirah", 25000, "ECOM-H/FURNITURE");
		List<EcomProduct> typeList = new ArrayList<EcomProduct>();
		typeList.add(obj);
		when(productRepository.findByTypeId("ECOM-H/FURNITURE")).thenReturn(typeList);
		assertEquals(typeList, uiController.getTypeFurniture());
	}
	
	@Test
	public void getTypeDecoreTest() {
		EcomProduct obj = new EcomProduct("ECOM-H/DECOR-001", "Wallpaper", 500, "ECOM-H/DECOR");
		List<EcomProduct> typeList = new ArrayList<EcomProduct>();
		typeList.add(obj);
		when(productRepository.findByTypeId("ECOM-H/DECOR")).thenReturn(typeList);
		assertEquals(typeList, uiController.getTypeDecore());
	}
	
	@Test
	public void saveToCartTest() {
		EcomCart obj = new EcomCart("sankhayan@gmail.com", "iPhone SE 2020", 36000);
		when(cartRepository.save(obj)).thenReturn(obj);
		assertEquals("Added To Cart", uiController.saveToCart(obj));
	}
	
	@Test
	public void viewCartTest() {
		EcomUser user = new EcomUser();
		user.setUserId("sankhayan@gmail.com");
		EcomCart obj = new EcomCart("sankhayan@gmail.com", "iPhone SE 2020", 36000);
		List<EcomCart> cartList = new ArrayList<EcomCart>();
		cartList.add(obj);
		when(cartRepository.findByUserId("sankhayan@gmail.com")).thenReturn(cartList);
		assertEquals(cartList, uiController.viewCart(user));
	}

}
