package com.fethi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "konu")
public class Konu {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "SEQ_KONU", sequenceName = "SEQ_KONU", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_KONU")
	private Integer id;

	@Column(name = "konu_basligi")
	private String konuBasligi;

	@Column(name = "konu_detay")
	private String konuDetay;
	

	public Konu(String konuBasligi, String konuDetay) {
		super();
		this.konuBasligi = konuBasligi;
		this.konuDetay = konuDetay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKonuBasligi() {
		return konuBasligi;
	}

	public void setKonuBasligi(String konuBasligi) {
		this.konuBasligi = konuBasligi;
	}

	public String getKonuDetay() {
		return konuDetay;
	}

	public void setKonuDetay(String konuDetay) {
		this.konuDetay = konuDetay;
	}

	@Override
	public String toString() {
		return "Konu [id=" + id + ", konuBasligi=" + konuBasligi + ", konuDetay=" + konuDetay + "]";
	}

	public Konu() {
		super();
	}

		
	

}
