package com.ecom;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecom.controller.UiController;
import com.ecom.entity.*;
import com.ecom.repository.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UiControllerTests {

	@Autowired
	private UiController uiController;

	@MockBean
	private CatalogRepository catalogRepository;

	@MockBean
	private TypeRepository typeRepository;

	@MockBean
	private ProductRepository productRepository;

	@MockBean
	private CartRepository cartRepository;

	@Test
	public void getCatalogTest() {
		when(catalogRepository.findAll())
				.thenReturn(Stream.of(new EcomCatalog("ECOM-E", "Electronics"), new EcomCatalog("ECOM-F", "Fashion"),
						new EcomCatalog("ECOM-H", "Home Appliances")).collect(Collectors.toList()));
		assertEquals(3, uiController.getCatalog().size());
	}

	@Test
	public void getElectronicsTest() {
		EcomType obj = new EcomType("ECOM-E/MOBILE", "Mobile", "ECOM-E");
		List<EcomType> typeList = new ArrayList<EcomType>();
		typeList.add(obj);
		when(typeRepository.findByCatalogId("ECOM-E")).thenReturn(typeList);
		assertEquals(typeList, uiController.getElectronics());
	}

}
