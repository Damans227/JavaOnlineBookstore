package com.bookstore.dao;


import static org.junit.Assert.*;

import java.util.List;

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
		user.setEmail("DamansYash@gmail.com");
		user.setFullName("Damanpreet Arora");
		user.setPassword("MySecret");
		
		user = userDAO.update(user);
		
		String expected ="MySecret";
		String actual=user.getPassword();
		
		assertEquals(expected,actual);
		
	}
	
	@Test
	public void testGetUsersFound() {
		

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		
		Integer userId=1;
		Users user=userDAO.get(userId);
		if(user!=null) {
			
			System.out.println(user.getEmail());
		}
		assertNotNull(user);
		
	}
	
	@Test
	public void testGetUsersNotFound() {
		

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		
		Integer userId=99;
		Users user=userDAO.get(userId);
		
		assertNull(user);
		
	}
	
	@Test
	public void testDeleteUsers() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		
		Integer userId=1;
		userDAO.delete(userId);
		
		Users user=userDAO.get(userId);
		assertNull(user);
		
	}
	
	@Test
	public void testDeleteNonExistUsers() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		
		Integer userId=55;
		userDAO.delete(userId);
	
	}
	
	@Test
	public void testListAll() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		
		List<Users> listUsers = userDAO.listAll();
		
		for(Users user: listUsers) {
			
			System.out.println(user.getEmail());
		}
		
		assertTrue(listUsers.size()>0);
		
	}
	
	@Test
	public void testCount() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		
		long totalUsers=userDAO.count();
		assertEquals(4,totalUsers);
		
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
