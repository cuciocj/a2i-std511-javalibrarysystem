/**
 * @author CJ Cucio
 * @date 18 November 2019
 */

package yib00005xs.std511.library.controller;

import yib00005xs.std511.library.model.Admin;
import yib00005xs.std511.library.model.Response;
import yib00005xs.std511.library.dao.AdminDao;

public class RegistrationController {
    
    public Response doProcess(Admin admin) {
        Response response = new Response();
        AdminDao adminRepository = new AdminDao();
        
        if(adminRepository.create(admin)) {
            response = new Response(200, "Success");
        } else {
            response = new Response(501, "Username already exists");
        }
        
        return response;
    }
    
}
