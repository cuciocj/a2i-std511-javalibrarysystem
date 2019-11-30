package yib00005xs.std511.library.controller;

import org.junit.Test;
import yib00005xs.std511.library.model.Admin;
import yib00005xs.std511.library.model.Response;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author CJ Cucio
 */
public class RegistrationControllerTest {

    public RegistrationControllerTest() {

    }

    /**
     * Test of doProcess method, of class RegistrationController.
     */
    @Test
    public void testDoProcess() {
        System.out.println("doProcess");
        Admin admin = new Admin("test", "test", "test123");
        RegistrationController instance = new RegistrationController();
        Response expResult = new Response(200, "Success");
        Response result = instance.doProcess(admin);
        
        assertEquals(expResult.getCode(), result.getCode());
        assertEquals(expResult.getMessage(), result.getMessage());
        // TODO review the generated test code and remove the default call to fail.

    }

}
