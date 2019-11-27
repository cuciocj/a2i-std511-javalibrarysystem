/**
 * @author CJ Cucio
 * @date 25 November 2019
 */
package yib00005xs.std511.library.dao;

import yib00005xs.std511.library.model.Book;
import yib00005xs.std511.library.commons.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private final static String TABLE = "books";

    public List<Book> list() {
        List<Book> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + TABLE + " order by id";

        try {
            con = Util.getConnection();
            ps = con.prepareStatement(sql);

            System.out.println("BooksDao.list() SQL : " + ps.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book(rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getString("genre"),
                        rs.getString("publisher"),
                        rs.getInt("publication_year"),
                        rs.getInt("quantity"));
                list.add(book);
            }

        } catch (SQLException e) {
            System.out.println("BooksDao.list() ERROR : " + e.toString());
        } finally {
            Util.close(con, ps);
        }

        return list;
    }

    public Book find(Book item) {
        Book book = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + TABLE + " where 1 = 1";
        
        if(item.getId() != null) {
            sql += " and id = " + item.getId();
        }
        
        if(item.getIsbn() != null) {
            sql += " and isbn = '" + item.getIsbn() + "'";
        }
        
        try {
            con = Util.getConnection();
            ps = con.prepareStatement(sql);

            System.out.println("BooksDao.list() SQL : " + ps.toString());
            rs = ps.executeQuery();

            if (rs.next()) {
                book = new Book(rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getString("genre"),
                        rs.getString("publisher"),
                        rs.getInt("publication_year"),
                        rs.getInt("quantity"));
            }

        } catch (SQLException e) {
            System.out.println("BooksDao.list() ERROR : " + e.toString());
        } finally {
            Util.close(con, ps);
        }

        return book;
    }
    
    public boolean update(Book item) {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update " + TABLE + " SET title = ?, author = ?, isbn = ?, "
                + "genre = ?, publisher = ?, publication_year = ?, quantity = ? where id = ?";
        
        try {
            con = Util.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getTitle());
            ps.setString(2, item.getAuthor());
            ps.setString(3, item.getIsbn());
            ps.setString(4, item.getGenre());
            ps.setString(5, item.getPublisher());
            ps.setInt(6, item.getPublicationYear());
            ps.setInt(7, item.getQuantity());
            ps.setInt(8, item.getId());
            
            System.out.println("BookDao.update() SQL : " + ps.toString());
            if(ps.executeUpdate() > 0) {
                flag = true;
            }
            
        } catch (SQLException e) {
            System.out.println("BookDao.update() ERROR : " + e.toString());
        } finally {
            Util.close(con, ps);
        }
        
        return flag;
    }

    public boolean create(Book item) {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into " + TABLE + " (title, author, isbn, genre, publisher, publication_year, quantity)"
                + " values (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = Util.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getTitle());
            ps.setString(2, item.getAuthor());
            ps.setString(3, item.getIsbn());
            ps.setString(4, item.getGenre());
            ps.setString(5, item.getPublisher());
            ps.setInt(6, item.getPublicationYear());
            ps.setInt(7, item.getQuantity());

            System.out.println("BooksDao.create() SQL: " + ps.toString());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }

        } catch (SQLException e) {
            System.out.println("BooksDao.create() ERROR : " + e.toString());
        } finally {
            Util.close(con, ps);
        }

        return flag;
    }

    public boolean delete(Book item) {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from " + TABLE + " where id = ?";

        try {
            con = Util.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getId());

            System.out.println("BooksDao.delete() SQL: " + ps.toString());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }

        } catch (SQLException e) {
            System.out.println("BooksDao.delete() ERROR : " + e.toString());
        } finally {
            Util.close(con, ps);
        }

        return flag;
    }
    
    public boolean delete(List<Book> list) {
        Boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from " + TABLE + " where isbn in (";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size() ; i++) {
            sb.append("?,");
        }
        
        sql = sql + sb.deleteCharAt(sb.length() - 1).toString() + ")";

        try {
            con = Util.getConnection();
            ps = con.prepareStatement(sql);
            
            int index = 1;
            for(Book book : list) {
                ps.setString(index, book.getIsbn());
                index++;
            }

            System.out.println("BooksDao.delete() SQL: " + ps.toString());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }

        } catch (SQLException e) {
            System.out.println("BooksDao.delete() ERROR : " + e.toString());
        } finally {
            Util.close(con, ps);
        }

        return flag;
    }

}
