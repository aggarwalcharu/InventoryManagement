package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Stock")
public class Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="quantity")
	private int quantity;
	
	@OneToOne
	//@OneToOne(fetch = FetchType.LAZY,
       //     cascade =  CascadeType.ALL,
        //    mappedBy = "raw_materials_id")
	private RawMaterials rawMaterials;

	public Stock( int id,int quantity){ 
		super();
		this.id = id;
		this.quantity = quantity;
		
	}

	public Stock() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public RawMaterials getRawMaterials() {
		return rawMaterials;
	}

	public void setRawMaterials(RawMaterials rawMaterials) {
		this.rawMaterials = rawMaterials;
	}
	
	

}
