/**
 * @author CJ Cucio
 * @date 28 November 2019
 */

package yib00005xs.std511.library.model;

public class Transaction extends Entity {
    
    private Student student;
    
    private Book book;
    
    private Integer quantity;
    
    private String status;
    
    private String dateBorrowed;
    
    private String dueDate;
    
    private String dateReturned;
    
    private Admin admin;

    public Transaction(Integer id, Student student, Book book, Integer quantity,
            String status, String dateBorrowed, String dueDate, String dateReturned, Admin admin) {
        super(id);
        this.student = student;
        this.book = book;
        this.quantity = quantity;
        this.status = status;
        this.dateBorrowed = dateBorrowed;
        this.dueDate = dueDate;
        this.dateReturned = dateReturned;
        this.admin = admin;
    }

    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public String getDateBorrowed() {
        return dateBorrowed;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDateReturned() {
        return dateReturned;
    }

    public Admin getAdmin() {
        return admin;
    }
    
}
