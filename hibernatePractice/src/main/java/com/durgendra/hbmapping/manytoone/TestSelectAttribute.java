package com.durgendra.hbmapping.manytoone;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestSelectAttribute {
	
	public static void main(String[] args) {


		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 
		
		String query = "select emp.id, emp.name , emp.email from "+Employee.class.getCanonicalName()+" emp where address_id="+40;
		TypedQuery<Object[]> emp = session.createQuery(query);
		List<Object[]> empList = emp.getResultList();
		empList.stream().forEach(empl->{
			System.out.println(empl[0]+" "+empl[1]);
		});
		t.commit();
		session.close();
	
	
	}

}
