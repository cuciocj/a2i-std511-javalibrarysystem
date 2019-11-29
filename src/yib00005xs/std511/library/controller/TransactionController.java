/**
 * @author CJ Cucio
 * @date 29 November 2019
 */
package yib00005xs.std511.library.controller;

import java.util.List;
import yib00005xs.std511.library.dao.BookDao;
import yib00005xs.std511.library.dao.StudentDao;
import yib00005xs.std511.library.dao.TransactionDao;
import yib00005xs.std511.library.model.Transaction;

public class TransactionController {

    private TransactionDao transactionDao;
    
    private StudentDao studentDao;
    
    private BookDao bookDao;

    public TransactionController() {
        transactionDao = new TransactionDao();
        studentDao = new StudentDao();
        bookDao = new BookDao();
    }

    // insert into transactions table
    // update book count
    // update student status
    public boolean doBorrowProcess(List<Transaction> transactions) {
        if(transactionDao.create(transactions)) {
            for(Transaction trx : transactions) {
                studentDao.update(trx.getStudent());
                bookDao.update(trx.getBook());
            }
            System.out.println("TransactionController.doBorrowProcess() : success creating transactions");
            return true;
        } else {
            return false;
        }
    }
    
    public boolean doReturnProcess(List<Transaction> transaction) {
        return false;
    }

}
