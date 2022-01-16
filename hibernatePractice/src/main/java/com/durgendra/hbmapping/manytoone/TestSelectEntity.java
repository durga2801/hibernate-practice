package com.durgendra.hbmapping.manytoone;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestSelectEntity {
	public static void main(String[] args) {

		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 
		
		List<Employee> list = session.createQuery("from  "+Employee.class.getCanonicalName()+"").getResultList();
		if(!list.isEmpty()) {
			for(Employee emp : list) {
				System.out.println(emp);
			}
		}

		t.commit();
		session.close();
	
	}
}
