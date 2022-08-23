package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Book;

public interface IBookDAO extends JpaRepository<Book, Long>{
	
	/**
	 * Gets a list of books with the same title as the one given
	 * 
	 * @param title the title
	 * @return the list of books
	 */
	public List<Book> getBooksByTitle(String title);
}