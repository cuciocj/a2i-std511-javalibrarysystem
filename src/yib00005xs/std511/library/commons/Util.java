/**
 * @author CJ Cucio
 * @date 14 November 2019
 */

package yib00005xs.std511.library.commons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class Util {
    
    private static final String HOST = "localhost";
    private static final String DATABASE = "javalibrarysystem";
    private static final String USERNAME = "aspire2";
    private static final String PASSWORD = "aspire2";
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://" + HOST + ":5432/" + DATABASE, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("Util.getConnection() ERROR: " + e.toString());
        }
        return con;
    }
    
    public static void close(Connection con, PreparedStatement ps) {
        try {ps.close();} catch (Exception e) {}
        try {con.close();} catch (Exception e) {}
    }

}
