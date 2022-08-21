package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Book;

public interface IBookDAO extends JpaRepository<Book, Long>{

}
