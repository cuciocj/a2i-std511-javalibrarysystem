/**
 * @author CJ Cucio
 * @date 14 November 2019
 */

package yib00005xs.std511.library.model;

public class User extends Entity {
    
    private String name;

    public User() {
    
    }
    
    public User(Integer id) {
        super(id);
    }
    
    public User(String name) {
        this.name = name;
    }

    public User(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
