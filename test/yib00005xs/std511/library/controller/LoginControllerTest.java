package yib00005xs.std511.library.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import yib00005xs.std511.library.controller.request.LoginRequest;
import yib00005xs.std511.library.model.Response;

/**
 *
 * @author CJ Cucio
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    /**
     * Test of doProcess method, of class LoginController.
     */
    @Test
    public void testDoProcess() {
        LoginRequest loginRequest = new LoginRequest("cuciocj", "qwe123");
        LoginController instance = new LoginController();
        Response expResult = new Response(200, "Success");
        Response result = instance.doProcess(loginRequest);
        assertEquals(expResult.getCode(), result.getCode());
        assertEquals(expResult.getMessage(), result.getMessage());
    }

}
