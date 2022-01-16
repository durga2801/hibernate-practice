package com.durgendra.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.durgendra.hibernate.model.Address;
import com.durgendra.hibernate.model.Employee;
import com.durgendra.hibernate.util.HibernateUtil;

public class HibernateSaveData {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sesion = sessionFactory.openSession();
		Transaction txn = sesion.beginTransaction();
		Employee emp = new Employee();
		emp.setName("Durga");
		emp.setSalary(10000.0D);
		Address address = new Address();
		address.setAddressLine1("01");
		emp.setAddress(address);
		//address.setEmployee(emp);
		address.setCity("Jaithari");
		address.setZipcode("4042733");
		sesion.save(emp);
		txn.commit();
		sesion.close();
		
	}

}
