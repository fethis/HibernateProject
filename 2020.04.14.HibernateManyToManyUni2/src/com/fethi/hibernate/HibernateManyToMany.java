package com.fethi.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fethi.entity.Kurs;
import com.fethi.entity.Ogrenci;
import com.fethi.entity.Ogretmen;
import com.fethi.entity.OgretmenDetay;

public class HibernateManyToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Ogrenci.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//Ogretmen ogr = session.get(Ogretmen.class, 22);
		
		Kurs kurs = session.get(Kurs.class, 44);
		
		Ogrenci ogrenci = new Ogrenci("hasan", "husey", 113);
		Ogrenci ogrenci1 = new Ogrenci("alper", "yıl", 114);
		
		
		kurs.addOgrenci(ogrenci);
		kurs.addOgrenci(ogrenci1);
	
		session.save(kurs);

		session.getTransaction().commit();

		session.close();

	}

}
