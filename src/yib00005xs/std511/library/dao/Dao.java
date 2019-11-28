/**
 * @author CJ Cucio
 * @date 28 November 2019
 */

package yib00005xs.std511.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// TODO implement singleton
public class Dao {
    
    private final String host = "localhost";
    private final String database = "javalibrarysystem";
    private final String username = "aspire2";
    private final String password = "aspire2";

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + database, username, password);
        } catch (Exception e) {
            System.out.println("Dao.getConnection() ERROR: " + e.toString());
        }
        return con;
    }
    
    public void close(Connection con, PreparedStatement ps) {
        try {ps.close();} catch (Exception e) {}
        try {con.close();} catch (Exception e) {}
    }
    
}
