package com.durgendra.hbmapping.manytoone;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestUpdateAddress {
	
	public static void main(String[] args) {


		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 
		
		Query query = session.createQuery("update "+Employee.class.getCanonicalName()+" set address_id=:aid where id=:id");
		query.setParameter("id", new Long(41));
		query.setParameter("aid", new Long("39"));
		int result = query.executeUpdate();
		System.out.println("--------"+result);

		t.commit();
		session.close();
	
	
	}

}
