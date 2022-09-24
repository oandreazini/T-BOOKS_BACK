package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Loan;
import com.example.demo.service.BookServiceImpl;
import com.example.demo.service.LoanServiceImpl;
import com.example.demo.service.UserDetailsServiceImpl;

@RestController
public class LoanController {

	@Autowired
	LoanServiceImpl loanServiceImpl;

	@Autowired
	BookServiceImpl bookServiceImpl;

	@Autowired
	UserDetailsServiceImpl userServiceImpl;

	@GetMapping("/loans")
	public List<Loan> getAllLoans() {
		return loanServiceImpl.listAllLoans();
	}

	@PostMapping("/loans")
	public Loan saveLoan(@RequestBody Loan l) {
		return loanServiceImpl.saveLoan(l);
	}

	@GetMapping("/loans/{id}")
	public Loan getLoanById(@PathVariable(name = "id") Long id) {
		return loanServiceImpl.loanById(id);
	}

	@PutMapping("/loans/{id}")
	public Loan updateLoan(@PathVariable(name = "id") Long id, @RequestBody Loan l) {
		Loan selectedLoan;
		Loan updatedLoan;

		selectedLoan = loanServiceImpl.loanById(id);

		selectedLoan.setStart(l.getStart());
		selectedLoan.setFinish(l.getFinish());
		selectedLoan.setValuation(l.getValuation());
		selectedLoan.setComment(l.getComment());
		selectedLoan.setUsuario(l.getUsuario());
		selectedLoan.setBook(l.getBook());

		updatedLoan = loanServiceImpl.saveLoan(selectedLoan);

		return updatedLoan;
	}

	@DeleteMapping("/loans/{id}")
	public void deleteLoan(@PathVariable(name = "id") Long id) {
		loanServiceImpl.deleteLoan(id);
	}

	@GetMapping("/loans/book/{id}")
	public List<Loan> findLoansByBook(@PathVariable(name = "id") Long idBook) {
		return loanServiceImpl.findLoansByBook(bookServiceImpl.bookById(idBook));
	}

	@GetMapping("/loans/usuario/{id}")
	public List<Loan> findLoansByUsuario(@PathVariable(name = "id") Long idUser) {
		return loanServiceImpl.findLoansByUsuario(userServiceImpl.userById(idUser));
	}
}
