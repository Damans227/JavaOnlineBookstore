package com.bookstore.test;

import javax.persistence.*;
import com.bookstore.entity.*;

public class CategoryTest {

	public static void main(String[] args) {
		
			Category newCat=new Category("Core Java");
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
			EntityManager entityManager=entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(newCat);
			entityManager.getTransaction().commit();
			
			entityManager.close();
			
			System.out.println("Successfully Persisted");

	}

}
