package com.durgendra.hbmapping;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestMainSingleEntity {
	
	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	      
	    SessionFactory factory=meta.getSessionFactoryBuilder().build(); 
	    
	    Session session=factory.openSession();  
	      
	    Transaction t=session.beginTransaction(); 
	    CorporateDetail corp1 = new CorporateDetail();
	    corp1.setCode("DURGA");
	    corp1.setName("Durgendra Singh");
	    corp1.setType("B");
	    session.save(corp1);
	    CorporateDetail corp2 = new CorporateDetail();
	    corp2.setCode("PRET");
	    corp2.setName("Preeti Singh");
	    corp2.setType("S");
	    session.save(corp2);
	    Date date = new Date();
	    Date expDate = new Date();
	    expDate.setDate(20);
	    InvoiceEntry invEntry = new InvoiceEntry(null, "INV00001", "IN0001", date, expDate);
	    session.save(invEntry);
	    InvoiceEntryDetail ied = new InvoiceEntryDetail(null, "INVD0001", 20000.0, "IND00001", invEntry.getId());
	    session.save(ied);
	    t.commit();
	    session.close();
	}

}
