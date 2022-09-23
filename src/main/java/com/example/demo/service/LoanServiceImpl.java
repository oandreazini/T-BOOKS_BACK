package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ILoanDAO;
import com.example.demo.dto.Book;
import com.example.demo.dto.Loan;
import com.example.demo.dto.Usuario;

@Service
public class LoanServiceImpl implements ILoanService {
	
	@Autowired
	ILoanDAO iLoanDAO;
	
	@Override
	public List<Loan> listAllLoans() {
		return iLoanDAO.findAll();
	}

	@Override
	public Loan saveLoan(Loan l) {
		return iLoanDAO.save(l);
	}

	@Override
	public Loan loanById(Long id) {
		return iLoanDAO.findById(id).get();
	}

	@Override
	public Loan updateLoan(Loan l) {
		return iLoanDAO.save(l);
	}

	@Override
	public void deleteLoan(Long id) {
		iLoanDAO.deleteById(id);
	}

	@Override
	public List<Loan> findLoansByBook(Book book) {
		return iLoanDAO.findLoansByBook(book);
	}
	
	@Override
	public List<Loan> findLoansByUsuario(Usuario usuario) {
		return iLoanDAO.findLoansByUsuario(usuario);
	}

}
