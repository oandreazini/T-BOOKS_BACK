package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IBookDAO;
import com.example.demo.dto.Book;

@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	IBookDAO iBookDAO;

	@Override
	public List<Book> listAllBooks() {
		return iBookDAO.findAll();
	}

	@Override
	public Book saveBook(Book b) {
		return iBookDAO.save(b);
	}

	@Override
	public Book bookById(Long id) {
		return iBookDAO.findById(id).get();
	}

	@Override
	public Book updateBook(Book b) {
		return iBookDAO.save(b);
	}

	@Override
	public void deleteBook(Long id) {
		iBookDAO.deleteById(id);
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		return iBookDAO.getBooksByTitle(title);
	}
}
