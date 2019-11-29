/**
 * @author CJ Cucio
 * @date 25 November 2019
 */

package yib00005xs.std511.library.model;

public class Student extends User {
    
    private String schoolId;
    
    private String status;
    
    public Student(Integer id) {
        super(id);
    }

    public Student(String schoolId, Integer id, String name, String status) {
        super(id, name);
        this.schoolId = schoolId;
        this.status = status;
    }
    
    public String getSchoolId() {
        return schoolId;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
}
