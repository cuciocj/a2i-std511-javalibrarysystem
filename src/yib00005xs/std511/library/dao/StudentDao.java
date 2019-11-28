/**
 * @author CJ Cucio
 * @date 28 November 2019
 */
package yib00005xs.std511.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import yib00005xs.std511.library.model.Student;

public class StudentDao extends Dao {

    private static final String TABLE = "students";

    public Student find(Student item) {
        Student student = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + TABLE + " WHERE id = ? or school_id = ?";

        try {
            con = getConnection();
            ps = con.prepareStatement(sql);

            if (item.getId() != null) {
                ps.setInt(1, item.getId());
            } else {
                ps.setInt(1, 0);
            }
            
            if (item.getSchoolId() != null) {
                ps.setString(2, item.getSchoolId());
            } else {
                ps.setString(2, "");
            }
            
            System.out.println("StudentDao.findById() SQL : " + ps.toString());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                student = new Student(rs.getString("school_id"),
                        rs.getInt("id"),
                        rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("StudentDao.find() ERROR : " + e.toString());
        } finally {
            close(con, ps);
        }

        return student;
    }
    
    public List<Student> list() {
        List<Student> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + TABLE + " order by name asc";
        
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            
            System.out.println("StudentDao.list() SQL : " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Student s = new Student(rs.getString("school_id"),
                        rs.getInt("id"),
                        rs.getString("name"));
                list.add(s);
            }
            
        } catch (SQLException e) {
            System.out.println("StudentDao.list() ERROR : " + e.toString());
        } finally {
            close(con, ps);
        }
        
        return list;
    }

}
