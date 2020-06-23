package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.RawMaterialsController;
import com.example.demo.entity.RawMaterials;
import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.repository.RawMaterialsRepository;

@Service
public class RawMaterialService {
	
	private static final Logger logger = LoggerFactory.getLogger(RawMaterialService.class);

	@Autowired
	RawMaterialsRepository rawMaterialsRepository;

	public List<RawMaterials> getAllRawMaterials() {
		return rawMaterialsRepository.findAll();
	}

	public void addRawMaterials(RawMaterials rawMaterials) {
		rawMaterialsRepository.save(rawMaterials);
	}

	public RawMaterials updateRawMaterial(RawMaterials rawMaterial) throws RawMaterialsNotFoundException {

		Optional<RawMaterials> rawMaterialDB = this.rawMaterialsRepository
				.findById(rawMaterial.getId());
		RawMaterials rawMaterialUpdate = rawMaterialDB.get();
		if (rawMaterialDB.isPresent()) {
			
			rawMaterialUpdate.setId(rawMaterial.getId());
			rawMaterialUpdate.setName(rawMaterial.getName());
			rawMaterialUpdate.setCost(rawMaterial.getCost());
			rawMaterialsRepository.save(rawMaterialUpdate);
			logger.debug("Raw materals is updated with values"+ rawMaterialUpdate);
			return rawMaterialUpdate;
		}else{
			logger.error("Raw Material id doesnot exist.");
			throw new RawMaterialsNotFoundException("Raw Material id doesnot exist.");
		}
			
	}

	public void deleteRawMaterial(int id) throws RawMaterialsNotFoundException {
		Optional < RawMaterials > rawMaterialDB = this.rawMaterialsRepository.findById(id);

        if (rawMaterialDB.isPresent()) {
            this.rawMaterialsRepository.delete(rawMaterialDB.get());
            logger.debug("Raw Material deleted successfully.");
       	}else{
       		logger.error("Raw Material id doesnot exist.");
			throw new RawMaterialsNotFoundException("Raw Material id not found.");
	}
	}

	public RawMaterials getRawMaterialById(int id) throws RawMaterialsNotFoundException {
		Optional < RawMaterials > rawMaterialDB = this.rawMaterialsRepository.findById(id);
		if (rawMaterialDB.isPresent()) {
			return rawMaterialDB.get();
        } else {
        	logger.error("Raw Material id doesnot exist.");
            throw new RawMaterialsNotFoundException("Record not found with id : " + id);
        }
		
	}
		
	

}