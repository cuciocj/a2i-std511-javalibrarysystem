/**
 * @author CJ Cucio
 * @date 25 November 2019
 */

package yib00005xs.std511.library.controller;

import java.util.List;
import yib00005xs.std511.library.dao.BookDao;
import yib00005xs.std511.library.model.Book;

public class BookController {
    
    private final BookDao bookRepository;
    
    public BookController() {
        bookRepository = new BookDao();
    }
    
    public List<Book> getBooksList() {
        return bookRepository.list();
    }
    
    public Book getBook(Book book) {
        return bookRepository.find(book);
    }
    
    public boolean addBook(Book book) {
        return bookRepository.create(book);
    }
    
    public boolean removeBook(Book book) {
        return bookRepository.delete(book);
    }
    
}
