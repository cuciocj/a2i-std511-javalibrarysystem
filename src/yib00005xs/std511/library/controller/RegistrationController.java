/**
 * @author CJ Cucio
 * @date 18 November 2019
 */

package yib00005xs.std511.library.controller;

import javax.swing.JOptionPane;
import yib00005xs.std511.library.model.Admin;
import yib00005xs.std511.library.model.Response;
import yib00005xs.std511.library.repository.AdminRepository;

public class RegistrationController {
    
    
    // TODO response return object
    public Response doProcess(Admin admin) {
        Response response = new Response();
        AdminRepository adminRepository = new AdminRepository();
        
        if(adminRepository.create(admin)) {
            response = new Response(200, "Success");
        } else {
            response = new Response(501, "Username already exists");
        }
        
        return response;
    }
    
}
