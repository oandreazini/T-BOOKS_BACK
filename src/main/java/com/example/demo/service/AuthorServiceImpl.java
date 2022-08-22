package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAuthorDAO;
import com.example.demo.dto.Author;

@Service
public class AuthorServiceImpl implements IAuthorService{

	@Autowired
	IAuthorDAO iAuthorDAO;

	@Override
	public List<Author> listAllAuthors() {
		return iAuthorDAO.findAll();
	}

	@Override
	public Author saveAuthor(Author author) {
		return iAuthorDAO.save(author);
	}

	@Override
	public Author authorById(Long id) {
		return iAuthorDAO.findById(id).get();
	}

	@Override
	public Author updateAuthor(Author author) {
		return iAuthorDAO.save(author);
	}

	@Override
	public void deleteAuthor(Long id) {
		iAuthorDAO.deleteById(id);
	}
}
