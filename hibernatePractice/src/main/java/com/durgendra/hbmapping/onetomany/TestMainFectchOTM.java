package com.durgendra.hbmapping.onetomany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestMainFectchOTM {
	public static void main(String[] args) {



		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 
		InvoiceEntryOTM otm = session.get(InvoiceEntryOTM.class, new Long(26));
		InvoiceEntryDetailOTM ied = new InvoiceEntryDetailOTM(null, "INVD0001", 20000.0, "IND00001", null);
		InvoiceEntryDetailOTM ied2 = new InvoiceEntryDetailOTM(null, "INVD0001", 20000.0, "IND00001", null);

		List<InvoiceEntryDetailOTM> iedList = new ArrayList<InvoiceEntryDetailOTM>();
		iedList.add(ied);
		iedList.add(ied2);
		//otm.setIed(iedList);
		//session.update(otm);
		
		TypedQuery<InvoiceEntryOTM> query = session.createQuery(" from InvoiceEntryOTM");
		List<InvoiceEntryOTM> otmList = query.getResultList();
		
		otmList.stream().forEach(data->{
			System.out.println(data);
			data.getIed().stream().forEach(ied1->{
				System.out.println(ied1);
			});
		});
		t.commit();
		session.close();
		System.out.println(otm.getIed());
		
		
		
		

	
	}

}
