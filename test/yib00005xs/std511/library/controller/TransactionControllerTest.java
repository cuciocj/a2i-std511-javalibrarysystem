package yib00005xs.std511.library.controller;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yib00005xs.std511.library.model.Transaction;

/**
 *
 * @author CJ Cucio
 */
public class TransactionControllerTest {
    
    public TransactionControllerTest() {
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
     * Test of doBorrowProcess method, of class TransactionController.
     */
    @Test
    public void testDoBorrowProcess() {
        System.out.println("doBorrowProcess");
        List<Transaction> transactions = null;
        TransactionController instance = new TransactionController();
        boolean expResult = false;
        boolean result = instance.doBorrowProcess(transactions);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doReturnProcess method, of class TransactionController.
     */
    @Test
    public void testDoReturnProcess() {
        System.out.println("doReturnProcess");
        List<Transaction> transactions = null;
        TransactionController instance = new TransactionController();
        boolean expResult = false;
        boolean result = instance.doReturnProcess(transactions);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
