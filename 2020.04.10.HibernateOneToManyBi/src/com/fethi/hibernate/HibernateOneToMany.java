package com.fethi.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fethi.entity.Kurs;
import com.fethi.entity.Ogretmen;
import com.fethi.entity.OgretmenDetay;

public class HibernateOneToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

//		Ogretmen ogr = new Ogretmen(null, "Ali", "Can", "alican@gmail.com");
//
//		ogr.addKurs(new Kurs("Java", 600, ogr));
//
//		ogr.addKurs(new Kurs("DB", 300, null));
//		ogr.addKurs(new Kurs("Web", 200, null));
		
		Ogretmen ogr1 = new Ogretmen(null, "Veli", "Bey", "velib@gmail.com");
		
		ogr1.addKurs(new Kurs(".Net", 500, null));
		ogr1.addKurs(new Kurs("Office", 30, null));
		ogr1.addKurs(new Kurs("resim", 200, null));

		session.beginTransaction();
		
		//session.save(ogr);
		session.save(ogr1);

		session.getTransaction().commit();

		session.close();

	}

}
