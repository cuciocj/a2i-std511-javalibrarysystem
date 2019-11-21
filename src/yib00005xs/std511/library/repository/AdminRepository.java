/**
 * @author CJ Cucio
 * @date 14 November 2019
 */

package yib00005xs.std511.library.repository;

import yib00005xs.std511.library.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import yib00005xs.std511.library.commons.Util;

public class AdminRepository {
    
    private final static String TABLE = "admins";
    
    public Admin find(Admin item) {
       Admin admin = null;
       Connection con = null; 
       PreparedStatement ps = null;
       ResultSet rs = null;
       String sql = "select * from " + TABLE + " where username = ? and password = ?";
       
       try {
           con = Util.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, item.getUsername());
           ps.setString(2, item.getPassword());
           
           System.out.println("LoginRepository.find() SQL: " + ps.toString());
           rs = ps.executeQuery();
           if(rs.next()) {
               admin = new Admin(
                       rs.getInt("id"),
                       rs.getString("name"), 
                       rs.getString("username"),
                       rs.getString("password"));
           }
           
       } catch (SQLException e) {
           System.out.println("LoginRepository.find() ERROR: " + e.toString());
       } finally {
           Util.close(con, ps);
       }
       
       return admin;
    }
    
    public boolean update(Admin item) {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update " + TABLE + "(name, username, password)"
                + " SET name = ?, username = ?, password = ?"
                + " where id = ?";
        
        try {
            con = Util.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setString(2, item.getUsername());
            ps.setString(3, item.getPassword());
            ps.setInt(4, item.getId());
            
            System.out.println("AdminRepository.update() SQL: " + ps.toString());
            if(ps.executeUpdate() > 0) {
                flag = true;
            }
            
        } catch (SQLException e) {
            System.out.println("AdminRepository.update() ERROR: " + e.toString());
        } finally {
            Util.close(con, ps);
        }
        
        return flag;
    }
    
    public boolean create(Admin item) {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into " + TABLE + "(name, username, password) values "
                + "(?, ?, ?)";
        
        try {
            con = Util.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setString(2, item.getUsername());
            ps.setString(3, item.getPassword());
            
            System.out.println("AdminRepository.create() SQL: " + ps.toString());
            if(ps.executeUpdate() > 0) {
                flag = true;
            }
            
        } catch (SQLException e) {
            System.out.println("AdminRepository.create() ERROR: " + e.toString());
        } finally {
            Util.close(con, ps);
        }
        
        return flag;
    }

}
