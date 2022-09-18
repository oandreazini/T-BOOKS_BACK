package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "editorials")
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy="id")
	private List<Book> books;

	// Constructors

	/**
	 * Default constructor
	 */
	public Editorial() {

	}

	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param name
	 * @param books
	 */
	public Editorial(Long id, String name, List<Book> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}

	// Getters and setters

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * @return the list of Books
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Book")
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * To String of the class
	 */
	@Override
	public String toString() {
		return "Editorial [id=" + id + ", name=" + name + ", books=" + books + "]";
	}	

}