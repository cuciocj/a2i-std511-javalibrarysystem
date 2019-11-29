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
import yib00005xs.std511.library.model.Transaction;
import yib00005xs.std511.library.model.Admin;
import yib00005xs.std511.library.model.Book;
import yib00005xs.std511.library.model.Student;

public class TransactionDao extends Dao {
    
    private final static String TABLE = "transactions";
    
    public List<Transaction> list() {
        List<Transaction> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + TABLE + " order by id desc";
        
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            
            System.out.println("TransactionDao.list() SQL : " + ps.toString());
            rs = ps.executeQuery();
            while(rs.next()) {
                Transaction item = new Transaction(rs.getInt("id"),
                        new StudentDao().find(new Student(rs.getInt("student_id"))),
                        new BookDao().find(new Book(rs.getInt("book_id"))), 
                        rs.getInt("quantity"),
                        rs.getString("status"),
                        rs.getString("date_borrowed"), 
                        rs.getString("due_date"),
                        rs.getString("date_returned"),
                        new Admin(rs.getInt("id")));
                
                list.add(item);
            }
            
        } catch (SQLException e) {
            System.out.println("TransactionDao.list() ERROR : " + e.toString());
        } finally {
            close(con, ps);
        }
        
        return list;
    }
    
    public Transaction find(Transaction item) {
        Transaction transaction = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + TABLE + " where 1 = 1";
        
        if(item.getId() != null) {
            sql += " and id = " + item.getId();
        } else {
            sql += " and id = 0";
        }
        
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            
            System.out.println("TransactionDao.find() SQL: " + ps.toString());
            rs = ps.executeQuery();
            if(rs.next()) {
                transaction = new Transaction(rs.getInt("id"),
                        new Student(rs.getInt("student_id")),
                        new Book(rs.getInt("book_id")), 
                        rs.getInt("quantity"),
                        rs.getString("status"),
                        rs.getString("date_borrowed"), 
                        rs.getString("due_date"),
                        rs.getString("date_returned"),
                        new Admin(rs.getInt("id")));
            }
        } catch (SQLException e) {
            System.out.println("TransactionDao.find() ERROR : " + e.toString());
        } finally {
            close(con, ps);
        }
        
        return transaction;
    }
    
    public boolean create(List<Transaction> list) {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into " + TABLE 
                + "(student_id, book_id, quantity, status, date_borrowed, due_date, date_returned, admin_id)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            
            for(Transaction item : list) {
                ps.setInt(1, item.getStudent().getId());
                ps.setInt(2, item.getBook().getId());
                ps.setInt(3, item.getQuantity());
                ps.setString(4, item.getStatus());
                ps.setString(5, item.getDateBorrowed());
                ps.setString(6, item.getDueDate());
                ps.setString(7, item.getDateReturned());
                ps.setInt(8, item.getAdmin().getId());
                
                ps.addBatch();
            }
            
            System.out.println("TransactionDao.create() SQL : " + ps.toString());
            if(ps.executeBatch().length > 0) {
                flag = true;
            }
            
        } catch (SQLException e) {
            System.out.println("TransactionDao.create() ERROR : " + e.toString());
        } finally {
            close(con, ps);
        }
        
        return flag;
    }
    
    public boolean update(Transaction item) {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update " + TABLE + " set student_id = ?, book_id = ?, quantity = ?,"
                + " status = ?, date_borrowed = ?, due_date = ?, date_returned = ?, admin_id = ?"
                + " where id = ?";
        
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getStudent().getId());
            ps.setInt(2, item.getBook().getId());
            ps.setInt(3, item.getQuantity());
            ps.setString(4, item.getStatus());
            ps.setString(5, item.getDateBorrowed());
            ps.setString(6, item.getDueDate());
            ps.setString(7, item.getDateReturned());
            ps.setInt(8, item.getAdmin().getId());
            ps.setInt(9, item.getId());
            
            System.out.println("TransactionDao.update() SQL : " + ps.toString());
            if(ps.executeUpdate() > 0) {
                flag = true;
            }
            
        } catch (SQLException e) {
            System.out.println("TransactionDao.update() ERROR : " + e.toString());
        } finally {
            close(con, ps);
        }
        
        return flag;
    }
    
}
