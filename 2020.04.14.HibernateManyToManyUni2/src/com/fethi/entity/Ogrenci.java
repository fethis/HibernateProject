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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ogrenci")
public class Ogrenci {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "OGRENCI_SEQ", sequenceName = "OGRENCI_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OGRENCI_SEQ")
	private Integer id;
	
	
	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "ogrenci_no")
	private Integer ogrencino;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "ogrenci_kurs",
	joinColumns =@JoinColumn(name="ogrenci_id"),
	inverseJoinColumns = @JoinColumn(name="kurs_id"))
	private List<Kurs> kurslar;
	
	
	public void addKurs(Kurs o) {
		if(kurslar==null){
			kurslar = new ArrayList<Kurs>();
		}
		kurslar.add(o);
	}


	public Ogrenci() {
		super();
	}


	public Ogrenci(String firstname, String lastname, Integer ogrencino) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.ogrencino = ogrencino;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Integer getOgrencino() {
		return ogrencino;
	}


	public void setOgrencino(Integer ogrencino) {
		this.ogrencino = ogrencino;
	}


	public List<Kurs> getKurslar() {
		return kurslar;
	}


	public void setKurslar(List<Kurs> kurslar) {
		this.kurslar = kurslar;
	}
	
	

}
