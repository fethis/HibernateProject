package com.fethi.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fethi.entity.Kurs;
import com.fethi.entity.Ogretmen;
import com.fethi.entity.OgretmenDetay;

public class HibernateEagerLazyTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		//Ogretmen ogr = new Ogretmen(null, "Fethi", "Sen", "alican@2gmail.com");
		
		//ogr.setOgretmenDetay(new OgretmenDetay("java", "bis", "w.b.c", "w.bb.ss"));

		/*ogr.addKurs(new Kurs("Java1", 500, ogr));

		ogr.addKurs(new Kurs("DB12", 200, null));
		ogr.addKurs(new Kurs("Web23", 200, null));
		
		ogr.addKurs(new Kurs(".Net3", 500, null));
		ogr.addKurs(new Kurs("Office2", 30, null));
		ogr.addKurs(new Kurs("resim1", 200, null));*/
		
		

		session.beginTransaction();
		
		
		Ogretmen fethi =session.get(Ogretmen.class, 22);
		
		fethi.getKurslar().size();//ornek olarak getkursa referans yaptik (lazy)
	
		System.out.println(fethi);//Lazy burada calisir
		System.out.println(fethi.getKurslar());//Lazy burada calisir
		
		session.getTransaction().commit();
		//System.out.println(fethi);//Eager burada da calisir 
		//System.out.println(fethi.getKurslar());//Eager burada da calisir//Lazy burada calismaz

		session.close();

	}

}
