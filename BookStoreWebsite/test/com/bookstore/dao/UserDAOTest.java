package com.bookstore.dao;


import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	
	/*@BeforeClass
	public static void setUpClass() {
		
	
	}*/

	@Test
	public void testCreateUsers() {
		

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		
		Users user1=new Users();
		user1.setEmail("Unique@gmail.com");
		user1.setFullName("Unique Doe");
		user1.setPassword("Education1");
		
	
		user1=userDAO.create(user1);
		
		entityManager.close();
		
		entityManagerFactory.close();
		
		assertTrue(user1.getUserId()>0);
	}
	
	
	@Test
	public void testUpdateUsers() {
		

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		
		Users user=new Users();
		user.setUserId(1);
		user.setEmail("Damans227@gmail.com");
		user.setFullName("Damanpreet Arora");
		user.setPassword("MySecret");
		
		user = userDAO.update(user);
		
		String expected ="MySecret";
		String actual=user.getPassword();
		
		assertEquals(expected,actual);
		
	}
	
	
	
	
	/*@Test
	public void testCreateUsersFieldsNotSet() {
		
		Users user1=new Users();
		
		user1=userDAO.create(user1);

		
	}*/
	
	/*@AfterClass
	public static void tearDownClass() {
		
		
	}*/

}
