package com.ammodata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caliber {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long caliberId;

	public Long getCaliberId() {
		return caliberId;
	}
	public void setCaliberId(Long caliberId) {
		this.caliberId = caliberId;
	}
}
