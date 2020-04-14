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

public class HibernateManyToManyOrnek {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Ogrenci.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//1 ogrencinin aldıgı kursları listeleyelim
		Ogrenci ogrenci = session.get(Ogrenci.class, 1);
		for(Kurs kurs: ogrenci.getKurslar()) {
			  System.out.println(kurs.getKursadi());
			   }
		
		
		//databaseden ogrenci query edip kurs ekliyoruz
		/*Ogrenci ogrenci = session.get(Ogrenci.class, 1);
		Kurs kurs = session.get(Kurs.class,22);
		ogrenci.addKurs(kurs);
		session.save(kurs);*/

		session.getTransaction().commit();

		session.close();

	}

}
