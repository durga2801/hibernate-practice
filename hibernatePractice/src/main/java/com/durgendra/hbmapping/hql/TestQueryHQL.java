package com.durgendra.hbmapping.hql;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.durgendra.hbmapping.manytoone.Employee;

public class TestQueryHQL {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 

		Session session=factory.openSession();  

		Transaction t=session.beginTransaction(); 

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();


		/**
		 * Select All
		 */
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		List<Employee> empList = session.getEntityManagerFactory().createEntityManager().createQuery(criteriaQuery.select(root)).getResultList();
		empList.stream().forEach(data->{
			System.out.println(data);
		});

		/**
		 * Where Condition
		 */
		CriteriaQuery<Employee> whereQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root2 = whereQuery.from(Employee.class);
		whereQuery.select(root2).where(criteriaBuilder.equal(root2.get("id"), 41l));

		Query<Employee> q=session.createQuery(whereQuery);
		Employee empl=q.getSingleResult();
		System.out.println(empl);
		
		/**
		 * Select specific column
		 */
		
		CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<Employee> root3 = query.from(Employee.class);
        query.select(root3.get("id"));
        Query<Long> idList=session.createQuery(query);
        List<Long> list=idList.getResultList();
        list.stream().forEach(data->{
        	System.out.println("Id List Data = "+data);
        });
        
        /**
         * Select Multiple Column
         */
        
        CriteriaQuery<Object[]> objQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Employee> root4 = objQuery.from(Employee.class);
        objQuery.multiselect(root4.get("id"),root4.get("name"));
        Query<Object[]> columnList=session.createQuery(objQuery);
        List<Object[]> objList=columnList.getResultList();
        objList.stream().forEach(data->{
        	System.out.println("Id List Data = "+data[0]+" "+data[1]);
        });
        
		t.commit();
		session.close();


	}

}
