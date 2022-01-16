package com.durgendra.hbmapping.hql;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.durgendra.hbmapping.manytoone.Employee;

public class CriteriaQueryExample8 {
	
	/**
	 * Order By Clause
	 * @param args
	 */

   public static void main(String[] args) {

      Transaction transaction = null;
      Session session = HibernateUtil.getSessionFactory().openSession();
      try  {
         transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();

         CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
         Root<Employee> root = criteriaQuery.from(Employee.class);
         criteriaQuery.select(root);
         criteriaQuery.orderBy(builder.asc(root.get("code")));
         Query<Employee> query = session.createQuery(criteriaQuery);
         List<Employee> list = query.getResultList();
         for (Employee employee : list) {
            System.out.println("EMP NAME="+employee.getName()+"\t SALARY="+employee.getCode());
         }

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }
}