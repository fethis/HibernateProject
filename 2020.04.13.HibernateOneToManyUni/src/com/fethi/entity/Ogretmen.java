package com.fethi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ogretmen")
public class Ogretmen {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "OGRETMEN_SEQ", sequenceName = "ogretmen_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OGRETMEN_SEQ")
	private Integer id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ogretmen_detay_id")
	private OgretmenDetay ogretmenDetay;
	
	@OneToMany(mappedBy="ogretmen", cascade=CascadeType.ALL) //Kurs classina git private Ogretmen ogretmen; mapine bak
	private List<Kurs> kurslar; //listeye ders ekleme cikarma metodu yazacaz

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email")
	private String email;
	

	public Ogretmen(OgretmenDetay ogretmenDetay, String firstname, String lastname, String email) {
		super();
		this.ogretmenDetay = ogretmenDetay;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	

	public Ogretmen() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OgretmenDetay getOgretmenDetay() {
		return ogretmenDetay;
	}

	public void setOgretmenDetay(OgretmenDetay ogretmenDetay) {
		this.ogretmenDetay = ogretmenDetay;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public List<Kurs> getKurslar() {
		return kurslar;
	}



	public void setKurslar(List<Kurs> kurslar) {
		this.kurslar = kurslar;
	}

	public void addKurs(Kurs kurs) {//kurslari listeye ekliyoruz sadece
		if(kurslar == null)
			kurslar = new ArrayList<Kurs>();
		kurslar.add(kurs);
		kurs.setOgretmen(this);
	}


	@Override
	public String toString() {
		return "Ogretmen [id=" + id +  ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + "]";
	}


	
	

}
