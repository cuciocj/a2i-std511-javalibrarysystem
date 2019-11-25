/**
 * @author CJ Cucio
 * @date 25 November 2019
 */

package yib00005xs.std511.library.model;

public class Student {
    
    private Integer id;
    
    private String schoolId;
    
    private String name;

    public Student() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
