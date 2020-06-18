package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RawMaterials;
import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.service.RawMaterialService;

@RestController
@RequestMapping("/inventory")
public class RawMaterialsController {

	@Autowired
	RawMaterialService rawMaterialService;
	
	@PostMapping("/rawMaterials/add")
	public void addRawMaterials(@RequestBody RawMaterials rawMaterials) {
		rawMaterialService.addRawMaterials(rawMaterials);
	}
	
	@GetMapping("/rawMaterials")
	public List<RawMaterials> getAllRawMaterilas(){
		return rawMaterialService.getAllRawMaterials();
	}
	
	
	@PutMapping("rawMaterials/{id}")
    public ResponseEntity <RawMaterials> updateRawMaterial(@RequestBody RawMaterials rawMaterial, @PathVariable int id) {
		rawMaterial.setId(id);
		return ResponseEntity.ok(this.rawMaterialService.updateRawMaterial(rawMaterial));
    }
	
	@DeleteMapping("/rawMaterials/{id}")
    public HttpStatus deleteProduct(@PathVariable int id) throws RawMaterialsNotFoundException {
        this.rawMaterialService.deleteRawMaterial(id);
        return HttpStatus.OK;
	}
}
	

