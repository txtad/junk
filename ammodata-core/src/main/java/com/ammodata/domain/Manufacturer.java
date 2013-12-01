package com.ammodata.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long manufacturerID;

	public Long getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Long manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

}
