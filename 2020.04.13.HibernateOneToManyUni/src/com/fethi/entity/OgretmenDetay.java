package com.fethi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ogretmen_detay")
public class OgretmenDetay {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name="OGRETMEN_DET_SEQ",sequenceName="ogretmen_det_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "OGRETMEN_DET_SEQ")
	private Integer id;
	

	@Column(name = "expertise")
	private String expertise;
	
	@Column(name = "hobby")
	private String hobby;
	
	@Column(name = "website")
	private String website;
	
	
	@Column(name = "fb_page")
	private String fbpage;
	
	
	@OneToOne(mappedBy ="ogretmenDetay" ) //ogretmen classindaki ogretmenDetay (field)alanını referans ediyr
	private Ogretmen ogretmen;
	

	public OgretmenDetay() {
		super();
	}


	public OgretmenDetay(String expertise, String hobby, String website, String fbpage) {
		super();
		this.expertise = expertise;
		this.hobby = hobby;
		this.website = website;
		this.fbpage = fbpage;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getExpertise() {
		return expertise;
	}


	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getFbpage() {
		return fbpage;
	}


	public void setFbpage(String fbpage) {
		this.fbpage = fbpage;
	}


	public Ogretmen getOgretmen() {
		return ogretmen;
	}


	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}


	public OgretmenDetay(Integer id, String expertise, String hobby, String website, String fbpage) {
		super();
		this.id = id;
		this.expertise = expertise;
		this.hobby = hobby;
		this.website = website;
		this.fbpage = fbpage;
	}


	@Override
	public String toString() {
		return "OgretmenDetay [id=" + id + ", expertise=" + expertise + ", hobby=" + hobby + ", website=" + website
				+ ", fbpage=" + fbpage + "]";
	}
	
	
	
	
}
