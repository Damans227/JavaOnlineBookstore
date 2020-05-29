package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDaoTest extends BaseDAOTest{
	private static BookDAO bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		bookDao = new BookDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testUpdateBook() throws ParseException, IOException {
		
		Book existBook = new Book();
		existBook.setBookId(1);
		
		Category category = new Category("Python new");
		category.setCategoryId(8);
		existBook.setCategory(category);
		
		existBook.setTitle("new Effective Python");
		existBook.setAuthor("new Daman Arora");
		existBook.setDescription("new description new");
		existBook.setPrice(39.38f);
		existBook.setIsbn("2131112");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		existBook.setPublished(publishDate);
		
		String imagePath = "C:\\Users\\Administrator\\eclipse-workspace\\img\\EJ.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath ));
		
		existBook.setImage(imageBytes);
		Book updatedBook = bookDao.update(existBook);
		
		assertEquals(updatedBook.getTitle(), "new Effective Python");
	}
	
	
	@Test
	public void testCreateBook() throws ParseException, IOException {
		
		Book newBook = new Book();
		
		Category category = new Category("Advanced Java");
		category.setCategoryId(2);
		newBook.setCategory(category);
		
		newBook.setTitle("Effective Java");
		newBook.setAuthor("Joshua Bloch");
		newBook.setDescription("description");
		newBook.setPrice(39.38f);
		newBook.setIsbn("2131112");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		newBook.setPublished(publishDate);
		
		String imagePath = "C:\\Users\\Administrator\\eclipse-workspace\\img\\EJ.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath ));
		
		newBook.setImage(imageBytes);
		Book createdBook = bookDao.create(newBook);
		
		assertTrue(createdBook.getBookId()>0);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		Integer bookId = 100;
		bookDao.delete(bookId);
		
		assertTrue(true);
		
	}

	@Test
	public void testDeleteBookSuccess() {
		Integer bookId = 2;
		bookDao.delete(bookId);
		
		assertTrue(true);
		
	}
	
	@Test
	public void testGetBookFail() {
		Integer bookId = 99;
		Book book = bookDao.get(bookId);
		
		assertNull(book);
		
	}
	
	@Test
	public void testGetBookSuccess() {
		Integer bookId = 1;
		Book book = bookDao.get(bookId);
		
		assertNotNull(book);
		
	}
	
	@Test
	public void testListAll() {
		
		List<Book> listBooks = bookDao.listAll();
		
		
		for(Book aBook : listBooks) {
			
			System.out.println(aBook.getTitle()+ " - " + aBook.getAuthor());
		}
		
		assertFalse(listBooks.isEmpty());
	}
	
	@Test
	public void testfindByTitleNotExist() {
		String title ="Thinking java";
		Book book = bookDao.findByTitle(title);
		
		assertNull(book);
		
	}
	
	@Test
	public void testfindByTitleExist() {
		String title ="new Effective Python";
		Book book = bookDao.findByTitle(title);
		
		System.out.println(book.getAuthor());
		System.out.println(book.getPrice());
		
		assertNotNull(book);
		
	}
	
	@Test
	
	public void testCount() {
		
		long totalBooks = bookDao.count();
		
		assertEquals(1, totalBooks);
	}
	
}
