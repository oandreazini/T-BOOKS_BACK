package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Loan;

public interface ILoanService {
	/**
	 * Lists all the Loans
	 * @return
	 */
	public List<Loan> listAllLoans();

	/**
	 * Saves an Loan
	 * @param l
	 * @return
	 */
	public Loan saveLoan(Loan l);

	/**
	 * Gets the Loan by ID
	 * @param id
	 * @return
	 */
	public Loan loanById(Long id);

	/**
	 * Updates the Loan
	 * @param p
	 * @return
	 */
	public Loan updateLoan(Loan l);

	/**
	 * Deletes the Loan
	 * @param id
	 */
	public void deleteLoan(Long id);
}

