/**
 * @author CJ Cucio
 * @date 28 November 2019
 */

package yib00005xs.std511.library.dao;

import yib00005xs.std511.library.model.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao extends Dao {
    
    private final static String TABLE = "transactions";
    
    public List<Transaction> list() {
        List<Transaction> list = new ArrayList<>();
        
        return list;
    }
    
    public Transaction find(Transaction item) {
        Transaction transaction = null;
        Connection con = null;
        
        return transaction;
    }
    
    public boolean create(Transaction item) {
        Boolean flag = false;
        
        return flag;
    }
    
    public boolean update(Transaction item) {
        Boolean flag = false;
        
        return flag;
    }
    
}
