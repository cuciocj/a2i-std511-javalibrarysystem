/**
 * @author CJ Cucio
 * @date 14 November 2019
 */

package yib00005xs.std511.library.controller.request;

public class LoginRequest {
    
    private String username;
    
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
