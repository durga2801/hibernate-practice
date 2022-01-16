package com.durgendra.hbmapping.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.jcache.internal.JCacheRegionFactory;
import org.hibernate.stat.Statistics;

import com.durgendra.hbmapping.manytoone.Employee;

public class TestSecondLevelCache {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory2();
		Statistics stats = factory.getStatistics();
		System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
		System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		SecondLevelCacheModel model1 = session.load(SecondLevelCacheModel.class, 44L);
		
		System.out.println(model1);
		session.close();
		
		Session session4 = factory.openSession();
		SecondLevelCacheModel model2 = session4.load(SecondLevelCacheModel.class, 44L);
		
		System.out.println(model2);
		session4.close();
		
		SessionFactory factory2 = HibernateUtil.getSessionFactory();
		Session session2 = factory2.openSession();
		Employee e2 = session2.get(Employee.class, 41L);
		System.out.println(e2);
		session2.close();
		
		Session session3 = factory2.openSession();
		Employee e3 = session3.get(Employee.class, 41L);
		System.out.println(e3);
		session3.close();
		
		
	}

}
