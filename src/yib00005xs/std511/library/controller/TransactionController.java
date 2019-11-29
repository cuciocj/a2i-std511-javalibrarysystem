/**
 * @author CJ Cucio
 * @date 29 November 2019
 */
package yib00005xs.std511.library.controller;

import java.util.List;
import yib00005xs.std511.library.dao.BookDao;
import yib00005xs.std511.library.dao.StudentDao;
import yib00005xs.std511.library.dao.TransactionDao;
import yib00005xs.std511.library.model.Book;
import yib00005xs.std511.library.model.Student;
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
        if (transactionDao.create(transactions)) {
            studentDao.update(transactions.get(0).getStudent());

            for (Transaction trx : transactions) {
                bookDao.update(trx.getBook());
            }

            System.out.println("TransactionController.doBorrowProcess() : success borrow transactions");
            return true;
        } else {
            return false;
        }
    }

    // update into transactions table
    // update book count
    // update student status
    public boolean doReturnProcess(List<Transaction> transactions) {
        Transaction trx = transactions.get(0);
        trx.setStatus("returned");
        Student student = trx.getStudent();
        student.setStatus("clear");
        
        if (transactionDao.updateStatus(trx)) {
            studentDao.update(student);
            
            for(Transaction transaction : transactions) {
                Book book = transaction.getBook();
                book.setQuantity(book.getQuantity() + 1);
                bookDao.update(book);
            }
            
            System.out.println("TransactionController.doBorrowProcess() : success return transactions");
            return true;
        } else {
            return false;
        }
    }

}
