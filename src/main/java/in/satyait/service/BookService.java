package in.satyait.service;

import java.util.List;

import in.satyait.binding.Book;
import in.satyait.entity.BookEntity;

public interface BookService {
	
	
	public boolean  addBook(Book book);
	
	public  List<BookEntity> getBooks();
	
	public boolean updateBook(Integer bookId, Double price);
	
	public boolean deleteBook(Integer bookId);
	
	

}
