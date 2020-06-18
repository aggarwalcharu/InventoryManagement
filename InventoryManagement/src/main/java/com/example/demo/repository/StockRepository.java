package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RawMaterials;
import com.example.demo.entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Integer>{
	
	Stock findByRawMaterials(RawMaterials rawmaterials);

}
