package in.satyait.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.satyait.binding.Book;
import in.satyait.entity.BookEntity;
import in.satyait.repo.BookRepositiory;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepositiory repository;

	@Override
	public boolean addBook(Book book) {

		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(book, bookEntity);
		BookEntity save = repository.save(bookEntity);
		return save.getBookId() != null;
	}

	@Override
	public List<BookEntity> getBooks() {
		return repository.findAll();
	}

	@Override
	public boolean updateBook(Integer bookId, Double price) {
		Optional<BookEntity> findById = repository.findById(bookId);

		if (findById.isPresent()) {
			BookEntity bookEntity = findById.get();
			bookEntity.setBookPrice(price);
			repository.save(bookEntity);
			return true;

		}

		return false;
	}

	@Override
	public boolean deleteBook(Integer bookId) {

		try {
			repository.deleteById(bookId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
