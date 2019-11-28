/**
 * @author CJ Cucio
 * @date 14 November 2019
 */

package yib00005xs.std511.library.model;

public class Admin extends User {
    
    private String username;
    
    private String password;
    
    public Admin(Integer id) {
        super(id);
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Admin(String name, String username, String password) {
        super(name);
        this.username = username;
        this.password = password;
    }

    public Admin(Integer id, String name, String username, String password) {
        super(id, name);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
