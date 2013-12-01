package com.ammodata.domain;

public class Bullet {

	public enum Type {

	}

	private Long bulletID;
	private Manufacturer manufacturer;
	private Type type;

	public Long getBulletID() {
		return bulletID;
	}

	public void setBulletID(Long bulletID) {
		this.bulletID = bulletID;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
