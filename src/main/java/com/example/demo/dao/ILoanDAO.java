package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Loan;
import com.example.demo.dto.Book;
import com.example.demo.dto.Usuario;

public interface ILoanDAO extends JpaRepository<Loan, Long> {

	public List<Loan> findLoansByBook(Book book);

	public List<Loan> findLoansByUsuario(Usuario usuario);
}
