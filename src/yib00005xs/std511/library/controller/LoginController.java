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
    
    // TODO: do validations here
    public Response doProcess(LoginRequest loginRequest) {
        System.out.println("username: " + loginRequest.getUsername());
        System.out.println("password: " + loginRequest.getPassword());
        
        AdminRepository loginRepository = new AdminRepository();
        Admin admin = loginRepository.find(new Admin(loginRequest.getUsername(), loginRequest.getPassword()));
        if(admin != null) {
            System.out.println("FOUND " + admin.getUsername() + "|" + admin.getPassword());
        } else {
            System.out.println("NOT FOUND");
        }
        
        return null;
    }

}
