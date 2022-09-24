package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {

	// Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String start;

	private String finish;

	private Double valuation;

	private String comment;

	@ManyToOne
	@JoinColumn(name = "user")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "book")
	private Book book;

	// Constructors

	/**
	 * Default constructor
	 */

	public Loan() {

	}

	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param start
	 * @param finish
	 * @param bail
	 * @param valuation
	 * @param comment
	 * @param usuario
	 * @param book
	 */
	public Loan(Long id, String start, String finish, Double valuation, String comment, Usuario usuario, Book book) {
		this.id = id;
		this.start = start;
		this.finish = finish;
		this.valuation = valuation;
		this.comment = comment;
		this.usuario = usuario;
		this.book = book;
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
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the finish
	 */
	public String getFinish() {
		return finish;
	}

	/**
	 * @param finish the finish to set
	 */
	public void setFinish(String finish) {
		this.finish = finish;
	}

	/**
	 * @return the valuation
	 */
	public Double getValuation() {
		return valuation;
	}

	/**
	 * @param valuation the valuation to set
	 */
	public void setValuation(Double valuation) {
		this.valuation = valuation;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param user the user to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * To String of the class
	 */

	@Override
	public String toString() {
		return "Loan [id=" + id + ", start=" + start + ", finish=" + finish + ", valuation=" + valuation + ", comment="
				+ comment + ", usuario=" + usuario + ", book=" + book + "]";
	}

}
