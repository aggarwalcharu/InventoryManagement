package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RawMaterials;
import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.repository.RawMaterialsRepository;

@Service
public class RawMaterialService {

	@Autowired
	RawMaterialsRepository rawMaterialsRepository;

	public List<RawMaterials> getAllRawMaterials() {
		return rawMaterialsRepository.findAll();
	}

	public void addRawMaterials(RawMaterials rawMaterials) {
		rawMaterialsRepository.save(rawMaterials);
	}

	public RawMaterials updateRawMaterial(RawMaterials rawMaterial) {

		Optional<RawMaterials> rawMaterialDB = this.rawMaterialsRepository
				.findById(rawMaterial.getId());
		RawMaterials rawMaterialUpdate = rawMaterialDB.get();
		if (rawMaterialDB.isPresent()) {
			
			rawMaterialUpdate.setId(rawMaterial.getId());
			rawMaterialUpdate.setName(rawMaterial.getName());
			rawMaterialUpdate.setCost(rawMaterial.getCost());
			rawMaterialsRepository.save(rawMaterialUpdate);
		}
			return rawMaterialUpdate;
			
	}

	public void deleteRawMaterial(int id) throws RawMaterialsNotFoundException {
		Optional < RawMaterials > rawMaterialDB = this.rawMaterialsRepository.findById(id);

        if (rawMaterialDB.isPresent()) {
            this.rawMaterialsRepository.delete(rawMaterialDB.get());
       	}else
			throw new RawMaterialsNotFoundException("Raw Material id not found.");
	}
		
	

}