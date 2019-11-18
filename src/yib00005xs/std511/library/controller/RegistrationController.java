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
        Response response = null;
        AdminRepository adminRepository = new AdminRepository();
        
        // TODO
        if(adminRepository.create(admin)) {
            JOptionPane.showConfirmDialog(null, "Admin [" + admin.getUsername() + "] is created", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showConfirmDialog(null, "Username already exists", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        
        return response;
    }
    
}
