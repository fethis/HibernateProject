package com.fethi.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fethi.entity.Kurs;
import com.fethi.entity.Ogretmen;
import com.fethi.entity.OgretmenDetay;

public class HibernateOneToManyOrnek {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();


		Ogretmen ogr = session.get(Ogretmen.class, 15);	
		
		
		
		Kurs k=ogr.getKurslar().get(0);
		ogr.getKurslar().remove(0);
		session.remove(k);
		
		Kurs k2 =ogr.getKurslar().get(0);
		k2.setKursadi("DB23");
	//ogr.getKurslar().get(0).setKursadi("DB3");
		
		session.save(k2);
		session.save(ogr);
		
		session.getTransaction().commit();
		
		session.close();
		System.out.println(ogr);
		System.out.println(ogr.getKurslar());
	}

}
