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

	
}
