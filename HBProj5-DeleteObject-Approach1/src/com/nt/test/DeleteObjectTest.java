package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Event;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest {

	public static void main(String[] args) {
		
		Session ses=null;
		
		Event event=null;
		
		Transaction tx=null;
		
		 boolean flag=false;
		
		//Create Session 
		
		ses=HibernateUtil.getSession();
		
		try {
			
			tx=ses.beginTransaction();
			
				//prepare Object with Id
			
			event=new Event();
			
			event.setId(101);
			
			ses.delete(event);
			
			flag=true;

			
		}
		
		catch(HibernateException he) {
			
			flag=false;
			
			he.printStackTrace();
			
		}
		
		catch(Exception e) {
			
			flag=false;
			
			e.printStackTrace();
			
		}
		
		finally {
			
			if(flag) {
				
				tx.commit();
				
				System.out.println("Object Deleted");
				
			}
			
			else {
				
				tx.rollback();
				
				System.out.println("Object not  Deleted");
			}
			
			//close Objects
			
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main method

}//class