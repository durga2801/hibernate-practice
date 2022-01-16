package com.durgendra.hbmapping.onetomany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestMainSaveOTM {
	
	public static void main(String[] args) {


		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 
		CorporateDetailOTM corp1 = new CorporateDetailOTM();
		corp1.setCode("DURGA");
		corp1.setName("Durgendra Singh");
		corp1.setType("B");

		CorporateDetailOTM corp2 = new CorporateDetailOTM();
		corp2.setCode("PRET");
		corp2.setName("Preeti Singh");
		corp2.setType("S");

		Date date = new Date();
		Date expDate = new Date();
		expDate.setDate(20);
		InvoiceEntryDetailOTM ied = new InvoiceEntryDetailOTM(null, "INVD0001", 20000.0, "IND00001", null);
		InvoiceEntryDetailOTM ied2 = new InvoiceEntryDetailOTM(null, "INVD0001", 20000.0, "IND00001", null);
		
		List<CorporateDetailOTM> list = new ArrayList<CorporateDetailOTM>();
		list.add(corp2);
		list.add(corp1);
		List<InvoiceEntryDetailOTM> iedList = new ArrayList<InvoiceEntryDetailOTM>();
		iedList.add(ied);
		iedList.add(ied2);
		InvoiceEntryOTM invEntry = new InvoiceEntryOTM(null, "INV00001", "IN0001", date, expDate,list, iedList);

		session.save(invEntry);


		t.commit();
		session.close();

	}

}
