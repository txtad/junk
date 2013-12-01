package com.ammodata.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long recipeID;
	@ManyToOne
	@JoinColumn(name="caliber_id")
	private Caliber caliber;
	@Transient
	private Headstamp headstamp;
	@Transient
	private Bullet bullet;
	@Transient
	private Powder powder;
	@Transient
	private Primer primer;
	
	public Long getRecipeID() {
		return recipeID;
	}
	public void setRecipeID(Long recipeID) {
		this.recipeID = recipeID;
	}
	public Caliber getCaliber() {
		return caliber;
	}
	public void setCaliber(Caliber caliber) {
		this.caliber = caliber;
	}
	public Headstamp getHeadstamp() {
		return headstamp;
	}
	public void setHeadstamp(Headstamp headstamp) {
		this.headstamp = headstamp;
	}
	public Bullet getBullet() {
		return bullet;
	}
	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}
	public Powder getPowder() {
		return powder;
	}
	public void setPowder(Powder powder) {
		this.powder = powder;
	}
	public Primer getPrimer() {
		return primer;
	}
	public void setPrimer(Primer primer) {
		this.primer = primer;
	}
}
