package com.fethi.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "kurs")
public class Kurs {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "SEQ_KURS", sequenceName = "SEQ_KURS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_KURS")
	private Integer id;

	@Column(name = "kurs_adi")
	private String kursadi;

	@Column(name = "saat")
	private Integer saat;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "ogrenci_kurs",
	joinColumns =@JoinColumn(name="kurs_id"),
	inverseJoinColumns = @JoinColumn(name="ogrenci_id"))
	private List<Ogrenci> ogrenciler;

	@ManyToOne
	@JoinColumn(name="ogretmen_id")  //oneToManyBi 
	private Ogretmen ogretmen;

	public void addOgrenci (Ogrenci o) {
		if(ogrenciler==null){
			ogrenciler = new ArrayList<Ogrenci>();
		}
		ogrenciler.add(o);
	}
	

	public Kurs() {
		super();
	}

	public Kurs(String kursadi, Integer saat, Ogretmen ogretmen) {
		super();
		this.kursadi = kursadi;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKursadi() {
		return kursadi;
	}

	public void setKursadi(String kursadi) {
		this.kursadi = kursadi;
	}

	public Integer getSaat() {
		return saat;
	}

	public void setSaat(Integer saat) {
		this.saat = saat;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	@Override
	public String toString() {
		return "Kurs id=" + id + ", kursadi=" + kursadi + ", saat=" + saat;
	}

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	
	


}
