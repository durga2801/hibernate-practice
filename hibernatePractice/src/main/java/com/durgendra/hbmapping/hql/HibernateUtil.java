package com.durgendra.hbmapping.hql;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		return factory;
	}
	
	public static SessionFactory getSessionFactory2() {
		
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
		/*
		 * Map<String, Object> settings = new HashMap<>();
		 * settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
		 * 
		 * // Specify cache region factory class
		 * settings.put(Environment.CACHE_REGION_FACTORY,
		 * "org.hibernate.cache.jcache.JCacheRegionFactory");
		 * 
		 * // Specify cache provider settings.put("hibernate.javax.cache.provider",
		 * "org.ehcache.jsr107.EhcacheCachingProvider");
		 * registryBuilder.applySettings(settings);
		 */
		StandardServiceRegistry ssr=registryBuilder.configure("hibernate2.cfg.xml").build();  
		
		
        
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		return factory;
	}

}
