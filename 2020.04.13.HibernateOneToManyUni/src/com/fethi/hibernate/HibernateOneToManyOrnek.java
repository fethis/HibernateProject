package com.fethi.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fethi.entity.Konu;
import com.fethi.entity.Kurs;
import com.fethi.entity.Ogretmen;
import com.fethi.entity.OgretmenDetay;

public class HibernateOneToManyOrnek {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(Konu.class).addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		/*
		 * for(Kurs kurs: ogr.getKurslar()) { for (Konu konu : kurs.getKonular()) {
		 * System.out.println(konu); } }
		 */
		Ogretmen ogr = session.get(Ogretmen.class, 22);

		
		
		/*for (int i = 0; i < ogr.getKurslar().size(); i++) {
			System.out.println(ogr.getKurslar().get(i).getKursadi());

			for (int j = 0; j < ogr.getKurslar().get(i).getKonular().size(); j++) {
				System.out.println(ogr.getKurslar().get(i).getKonular().get(j));
			}

		}*/
		
		
		  for(Kurs kurs: ogr.getKurslar()) {
			  System.out.println(kurs.getKursadi());
			  for (Konu konu : kurs.getKonular()) {
		  System.out.println(konu); } }
		 

		session.getTransaction().commit();
		session.close();
	}

}