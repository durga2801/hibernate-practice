package com.durgendra.hbmapping.manytoone;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestSaveWithExistingAddress {
	
	public static void main(String[] args) {



		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 
		
		List<Address> list = session.createQuery("from  "+Address.class.getCanonicalName()+"").getResultList();
		if(!list.isEmpty()) {
			Employee employee  = new Employee();
			employee.setAddress(list.get(0));
			employee.setCode("4052");
			employee.setName("Durga");
			session.save(employee);
		}

		t.commit();
		session.close();

	
	}

}
