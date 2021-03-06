package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RawMaterials;
import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.service.RawMaterialService;

@RestController
@RequestMapping("/inventory")
public class RawMaterialsController {
	
	private static final Logger logger = LoggerFactory.getLogger(RawMaterialsController.class);

	@Autowired
	RawMaterialService rawMaterialService;
	
	@CachePut(value="rawMaterials",unless="#result==null")
	@PostMapping("/rawMaterials/add")
	public void addRawMaterials(@RequestBody RawMaterials rawMaterials) {
		rawMaterialService.addRawMaterials(rawMaterials);
	}
	
	@Cacheable(value="rawMaterials" ,unless="#result==null")
	@GetMapping("/rawMaterials")
	public List<RawMaterials> getAllRawMaterilas(){
		return rawMaterialService.getAllRawMaterials();
	}
	
	@Cacheable(value="rawMaterials",key ="#id",unless="#result==null")
	@GetMapping("/rawMaterials/{id}")
	@ResponseBody
	public RawMaterials getRawMaterialById(@PathVariable int id) throws RawMaterialsNotFoundException {
		logger.debug("ID searched for raw material",id);
	    return rawMaterialService.getRawMaterialById(id);
	            
	}
	@CachePut(value="rawMaterials",key="#id",unless="#result==null")
	@PutMapping("rawMaterials/{id}")
    public ResponseEntity <RawMaterials> updateRawMaterial(@RequestBody RawMaterials rawMaterial, @PathVariable int id) throws RawMaterialsNotFoundException {
		rawMaterial.setId(id);
		logger.debug("ID updated for raw material",id);
		return ResponseEntity.ok(this.rawMaterialService.updateRawMaterial(rawMaterial));
    }
	@CacheEvict(value="rawMaterials",key="#id")
	@DeleteMapping("/rawMaterials/{id}")
    public HttpStatus deleteProduct(@PathVariable int id) throws RawMaterialsNotFoundException {
        this.rawMaterialService.deleteRawMaterial(id);
        logger.debug("Raw material deleted successfully");
        return  HttpStatus.OK;
	}
	
	@CacheEvict(value="rawMaterials" ,allEntries=true)
	@RequestMapping("/clearCache")
	public String clearCache(){
		return "Clear Cache";
	}
	
	
}
	

