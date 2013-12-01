package com.ammodata.domain;

public class Powder {

	private Long powderID;
	private String powderName;
	private Manufacturer manufacturer;

	public Long getPowderID() {
		return powderID;
	}

	public void setPowderID(Long powderID) {
		this.powderID = powderID;
	}

	public String getPowderName() {
		return powderName;
	}

	public void setPowderName(String powderName) {
		this.powderName = powderName;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

}
