package com.durgendra.hbmapping.hql;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.durgendra.hbmapping.manytoone.Employee;

public class CriteriaQueryExample5 {

   public static void main(String[] args) {

      Transaction transaction = null;
      Session session = HibernateUtil.getSessionFactory().openSession();
      try {
         transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();

         // Count number of employees
         CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
         Root<Employee> root = criteriaQuery.from(Employee.class);
         criteriaQuery.select(builder.count(root));
         Query<Long> query = session.createQuery(criteriaQuery);
         long count = query.getSingleResult();
         System.out.println("Count = " + count);

         // Get max salary
/*         CriteriaQuery<Long> criteriaQuery2 = builder.createQuery(Long.class);
         Root<Employee> root2 = criteriaQuery2.from(Employee.class);
         criteriaQuery2.multiselect(builder.max(root2.get("id")));//builder.max(root2.get("id"))
         Query<Long> query2 = session.createQuery(criteriaQuery2);
         Long maxSalary = query2.getSingleResult();
         System.out.println("Max Salary = " + maxSalary);
*/
         // Get Average Salary
        /* CriteriaQuery<Double> criteriaQuery3 = builder.createQuery(Double.class);
         Root<Employee> root3 = criteriaQuery3.from(Employee.class);
         criteriaQuery3.select(builder.avg(root3.get("id")));
         Query<Double> query3 = session.createQuery(criteriaQuery3);
         double avgSalary = query3.getSingleResult();
         System.out.println("Average Salary = " + avgSalary);
		*/ 
         // Count distinct employees
         CriteriaQuery<Long> criteriaQuery4 = builder.createQuery(Long.class);
         Root<Employee> root4 = criteriaQuery4.from(Employee.class);
         criteriaQuery4.select(builder.countDistinct(root4));
         Query<Long> query4 = session.createQuery(criteriaQuery4);
         long distinct = query4.getSingleResult();
         System.out.println("Distinct count = " + distinct);

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }
}