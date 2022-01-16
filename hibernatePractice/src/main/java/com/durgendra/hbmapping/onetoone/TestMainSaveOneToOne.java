package com.durgendra.hbmapping.onetoone;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class TestMainSaveOneToOne {

	public static void main(String[] args) {

		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 
		CorporateDetailOTO corp1 = new CorporateDetailOTO();
		corp1.setCode("DURGA");
		corp1.setName("Durgendra Singh");
		corp1.setType("B");

		CorporateDetailOTO corp2 = new CorporateDetailOTO();
		corp2.setCode("PRET");
		corp2.setName("Preeti Singh");
		corp2.setType("S");

		Date date = new Date();
		Date expDate = new Date();
		expDate.setDate(20);
		InvoiceEntryDetailOTO ied = new InvoiceEntryDetailOTO(null, "INVD0001", 20000.0, "IND00001", null);
		InvoiceEntryOTO invEntry = new InvoiceEntryOTO(null, "INV00001", "IN0001", date, expDate,corp1,corp2, ied);

		ied.setInvEntry(invEntry);
		corp1.setInvEntry(invEntry);
		corp2.setInvEntry(invEntry);
		
		session.save(invEntry);


		t.commit();
		session.close();

	}

}
