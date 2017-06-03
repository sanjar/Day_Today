package com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.test.user.DBUser;
import com.test.util.HibernateUtil;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller; 
import javax.xml.bind.Marshaller; 

public class App {
	public static void main(String[] args) throws JAXBException {
		//System.out.println("Maven + Hibernate Annotation + Oracle");
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		
		
		
		session.beginTransaction();
		/*DBUser user = new DBUser();

		user.setUserId(101);
		user.setUsername("Hibernate102");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();*/
		
		Criteria criteria = session.createCriteria(DBUser.class);
		List<DBUser> users = criteria.list();
		JAXBContext jaxbContext = JAXBContext.newInstance(DBUser.class);  
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		for(DBUser u : users){
			System.out.println(u.getUserId());
			jaxbMarshaller.marshal(u, System.out);
		}
		
		 
		
	}
}
