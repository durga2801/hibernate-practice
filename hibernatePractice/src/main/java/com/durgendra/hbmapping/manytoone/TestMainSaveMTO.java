package com.durgendra.hbmapping.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestMainSaveMTO {
	public static void main(String[] args) {


		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 
		
		Address address = new Address();
		address.setCountryCode("US");
		address.setLandMark("ST PA");
		address.setProvinceCode("MP");
		address.setLine1("01");
		address.setLine1("02");
		
		session.save(address);


		t.commit();
		session.close();

	}

}
