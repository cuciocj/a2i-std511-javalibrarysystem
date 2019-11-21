/**
 * @author CJ Cucio
 * @date 14 November 2019
 */

package yib00005xs.std511.library.controller;

import yib00005xs.std511.library.controller.request.LoginRequest;
import yib00005xs.std511.library.model.Admin;
import yib00005xs.std511.library.model.Response;
import yib00005xs.std511.library.repository.AdminRepository;

public class LoginController {
    
    public Response doProcess(LoginRequest loginRequest) {
        Response response = new Response();
        System.out.println("username: " + loginRequest.getUsername());
        System.out.println("password: " + loginRequest.getPassword());
        
        AdminRepository loginRepository = new AdminRepository();
        Admin admin = loginRepository.find(new Admin(loginRequest.getUsername(), loginRequest.getPassword()));
        if(admin != null) {
            response = new Response(200, "Success");
        } else {
            response = new Response(501, "Invalid Credentials. Please try again!");
        }
        
        return response;
    }

}
