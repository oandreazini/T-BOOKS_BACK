package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Book> books;

	// Constructors

	/**
	 * Default constructor
	 */
	public Author() {

	}

	// Getters and setters

	/**
	 * @return the list of Books
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Book")
	public List<Book> getBooks() {
		return books;
	}
}