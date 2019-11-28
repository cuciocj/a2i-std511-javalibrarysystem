/**
 * @author CJ Cucio
 * @date 25 November 2019
 */

package yib00005xs.std511.library.model;

public class Student extends User {
    
    private String schoolId;
    
    public Student(Integer id) {
        super(id);
    }
    
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
    
}
