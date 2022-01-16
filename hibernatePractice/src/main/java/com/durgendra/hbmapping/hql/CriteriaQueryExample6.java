package com.durgendra.hbmapping.hql;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.durgendra.hbmapping.manytoone.Address;
import com.durgendra.hbmapping.manytoone.Employee;

public class CriteriaQueryExample6 {

	/**
	 * Join Query
	 * @param args
	 */
   public static void main(String[] args) {

      Transaction transaction = null;
      Session session = HibernateUtil.getSessionFactory().openSession();
      try  {
         transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();

         // Using FROM and JOIN
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Employee> empRoot = criteriaQuery.from(Employee.class);
         Root<Address> deptRoot = criteriaQuery.from(Address.class);
         criteriaQuery.multiselect(empRoot, deptRoot);
         criteriaQuery.where(builder.equal(empRoot.get("department"), deptRoot.get("id")));

         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         for (Object[] objects : list) {
            Employee employee=(Employee)objects[0];
            Address department=(Address)objects[1];
            System.out.println("EMP NAME="+employee.getName()+"\t DEPT NAME="+department.getCountryCode());
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
