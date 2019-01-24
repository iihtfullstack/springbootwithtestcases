package com.sunil.springData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sunil.springData.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>  {
	
	@Query("from Book where title like %:title%")
	public List<Book> findBooksByTitle (@Param("title")String title);

}
