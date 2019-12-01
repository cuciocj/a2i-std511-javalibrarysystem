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
     * Test of getBooksList method, of class BookController.
     */
    @Test
    public void testGetBooksList() {
        System.out.println("getBooksList");
        BookController instance = new BookController();
        List<Book> expResult = null;
        List<Book> result = instance.getBooksList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBook method, of class BookController.
     */
    @Test
    public void testGetBook() {
        System.out.println("getBook");
        Book book = null;
        BookController instance = new BookController();
        Book expResult = null;
        Book result = instance.getBook(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBook method, of class BookController.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        Book book = null;
        BookController instance = new BookController();
        boolean expResult = false;
        boolean result = instance.addBook(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeBook method, of class BookController.
     */
    @Test
    public void testRemoveBook() {
        System.out.println("removeBook");
        Book book = null;
        BookController instance = new BookController();
        boolean expResult = false;
        boolean result = instance.removeBook(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
