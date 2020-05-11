package com.bookstore.test;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;

import com.bookstore.entity.Users;


public class UsersTest {

	public static void main(String[] args) {
		
		Users user1=new Users();
		user1.setEmail("David@gmail.com");
		user1.setFullName("David Doe");
		user1.setPassword("Education1");
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		System.out.println("New User Successfully Persisted");
	}

}
