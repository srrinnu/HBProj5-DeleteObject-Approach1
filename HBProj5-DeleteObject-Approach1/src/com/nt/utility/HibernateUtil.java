package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	
	static {
		
		//Create Configuration class Object
		
		Configuration cfg=null;
		
		cfg=new Configuration();
		
		//Load Configure File
		
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		
		//Create SessionFactory Object
		
		factory=cfg.buildSessionFactory();
	
	}//static
	
	public static Session getSession() {
		
		if(factory!=null)
			
			return factory.openSession();
		else
			
			return null;
	}
	
	public static void closeSession(Session ses) {
		
		
		
		if(ses!=null)
			
			ses.close();
		
	}
	
	public static void closeSessionFactory() {
		
		if(factory!=null) {
			
			factory.close();
		}
	}

}