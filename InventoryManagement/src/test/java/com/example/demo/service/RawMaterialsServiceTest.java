package com.example.demo.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;









import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.RawMaterials;
import com.example.demo.repository.RawMaterialsRepository;
import com.example.demo.service.RawMaterialService;

@RunWith(MockitoJUnitRunner.class)
@WithMockUser(username = "user1", password = "secret1")
public class RawMaterialsServiceTest {
	
	@Mock
	RawMaterialsRepository rawMaterialsRepository;
	
	@InjectMocks
	RawMaterialService rawMaterialService;
	
	
	@Test
	public void testGetAllRawMaterials() {
		
		List<RawMaterials> rawMaterialsList = new ArrayList<RawMaterials>();
		rawMaterialsList.add(new RawMaterials(1, "Bread", 100));
		rawMaterialsList.add(new RawMaterials(2, "Butter", 500));
		Mockito.when(rawMaterialService.getAllRawMaterials()).thenReturn((rawMaterialsList));
			
		assertEquals(rawMaterialsList.size(), rawMaterialService.getAllRawMaterials().size());
	}
	@Test
	public void testGetAllRawMaterials_ComparingContents() {
		List<RawMaterials> rawMaterialsList=new ArrayList<RawMaterials>();
		rawMaterialsList.add(new RawMaterials(1, "Bread", 100));
		rawMaterialsList.add(new RawMaterials(2, "Butter", 500));
		
		Mockito.when(rawMaterialsRepository.findAll()).thenReturn(rawMaterialsList);
		assertEquals(rawMaterialsList.get(0).getName(), rawMaterialService.getAllRawMaterials().get(0).getName());
	}
	
	@Test
	public void testAddRawMaterials() {
		RawMaterials rawMaterials=new RawMaterials(8, "Coffee", 150);
		rawMaterialService.addRawMaterials(rawMaterials);
		verify(rawMaterialsRepository).save(rawMaterials);
	}
	
	

}
