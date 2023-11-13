package in.satyait.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satyait.entity.BookEntity;

public interface BookRepositiory  extends JpaRepository<BookEntity, Serializable>{

	
	
}
