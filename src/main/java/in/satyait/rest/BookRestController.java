package in.satyait.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.satyait.binding.Book;
import in.satyait.entity.BookEntity;
import in.satyait.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService service;

	@PostMapping("/addbook")
	public ResponseEntity<String> addBook(@RequestBody Book book) {

		boolean addBook = service.addBook(book);

		if (addBook) {
			return new ResponseEntity<>("Book Saved Successully", HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>("Book Failed to Save", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getBooks() {

		List<BookEntity> books = service.getBooks();

		return new ResponseEntity<List<BookEntity>>(books, HttpStatus.OK);

	}

	@PutMapping("/book/{bookId}/{price}")
	public ResponseEntity<String> updateBooks(@PathVariable Integer bookId, @PathVariable Double price) {

		boolean updateBook = service.updateBook(bookId, price);

		if (updateBook) {
			return new ResponseEntity<>("Book Updated Successfully", HttpStatus.OK);

		} else {

			return new ResponseEntity<>("Failed to Update Book", HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {

		boolean deleteBook = service.deleteBook(bookId);

		if (deleteBook) {
			return new ResponseEntity<>("Book Deleted Successfully", HttpStatus.OK);
		} else {

			return new ResponseEntity<>("we are unable to find the record", HttpStatus.BAD_REQUEST);
		}

	}

}
