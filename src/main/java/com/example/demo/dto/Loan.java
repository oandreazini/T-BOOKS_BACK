package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "loans")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date start;

	@Temporal(TemporalType.TIMESTAMP)
	private Date finish;

	private Double bail;

	private Double valuation;

	private String comment;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne
	@JoinColumn(name = "user")
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
	 * @param user
	 * @param book
	 */
	public Loan(Long id, Date start, Date finish, Double bail, Double valuation, String comment, User user, Book book) {
		this.id = id;
		this.start = start;
		this.finish = finish;
		this.bail = bail;
		this.valuation = valuation;
		this.comment = comment;
		this.user = user;
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
	public Date getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return the finish
	 */
	public Date getFinish() {
		return finish;
	}

	/**
	 * @param finish the finish to set
	 */
	public void setFinish(Date finish) {
		this.finish = finish;
	}

	/**
	 * @return the bail
	 */
	public Double getBail() {
		return bail;
	}

	/**
	 * @param bail the bail to set
	 */
	public void setBail(Double bail) {
		this.bail = bail;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
		return "Loan [id=" + id + ", start=" + start + ", finish=" + finish + ", bail=" + bail + ", valuation="
				+ valuation + ", comment=" + comment + ", user=" + user + ", book=" + book + "]";
	}

}
