package yib00005xs.std511.library.controller;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yib00005xs.std511.library.model.Book;

/**
 *
 * @author CJ Cucio
 */
public class BookControllerTest {
    
    public BookControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of addBook method, of class BookController.
     */
    @Before
    public void testAddBook() {
        Book book = new Book("testBook", "testAuthor", "testIsbn", "testGenre", "testPublisher", 0, 0);
        BookController instance = new BookController();
        boolean expResult = true;
        boolean result = instance.addBook(book);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBook method, of class BookController.
     */
    @Test
    public void testGetBook() {
        Book book = new Book("testIsbn");
        BookController instance = new BookController();
        Book expResult = new Book("testBook", "testAuthor", "testIsbn", "testGenre", "testPublisher", 0, 0);
        Book result = instance.getBook(book);
        assertEquals(expResult.getTitle(), result.getTitle());
    }

    /**
     * Test of removeBook method, of class BookController.
     */
    @After
    public void testRemoveBook() {
        Book book = new Book("testIsbn");
        BookController instance = new BookController();
        boolean expResult = true;
        boolean result = instance.removeBook(book);
        assertEquals(expResult, result);
    }
    
}
