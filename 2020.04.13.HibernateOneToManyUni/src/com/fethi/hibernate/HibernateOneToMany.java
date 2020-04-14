package com.fethi.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fethi.entity.Konu;
import com.fethi.entity.Kurs;
import com.fethi.entity.Ogretmen;
import com.fethi.entity.OgretmenDetay;

public class HibernateOneToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Konu.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		
		session.beginTransaction();
		Ogretmen ogr = session.get(Ogretmen.class, 22);//22 id li ogretmen //kurs ekledik//kursa konu ekledik
		
		Kurs kurs = new Kurs("Müzik", 300, ogr);
		
		kurs.addKonu(new Konu("Gitar", "Gitara baslangic"));
		kurs.addKonu(new Konu("Keman", "Keman öğrenme"));
		kurs.addKonu(new Konu("Flüt", "yan flüt"));
		
		
	
		session.save(kurs);

		session.getTransaction().commit();

		session.close();

	}

}
