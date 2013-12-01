package com.ammodata.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caliber {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long caliberID;

	public Long getCaliberID() {
		return caliberID;
	}
	public void setCaliberID(Long caliberID) {
		this.caliberID = caliberID;
	}
}
