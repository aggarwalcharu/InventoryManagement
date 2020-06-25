package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RawMaterials;
import com.example.demo.entity.Stock;
//import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.service.StockService;


@Api(tags= {"Stock Entity"})
@RestController
@RequestMapping("/inventory")
public class StockController {
	@Autowired
	StockService stockService;
	
	@ApiOperation(value="Get Stock",notes="")
	@GetMapping("/stock")
	public List<Stock> getAllRawMaterialsInStock(){
		
		return stockService.getAllRawMaterialsInStock();
	}

	@ApiOperation(value="add Stock",notes="")
	@PostMapping("/stock/add")
	public void addStock(@RequestBody Stock Stock,RawMaterials rawMaterials){
		Stock stock = new Stock();
		stock.setRawMaterials(rawMaterials);
		stockService.addStock(Stock);
	}
//	@DeleteMapping("/stock")
//	public void deleteRawMaterials(@RequestParam(name="name") String name) throws RawMaterialsNotFoundException {
//		stockService.deleteRawMaterials(name);
//	}
	
}