package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Loan;

public interface ILoanDAO extends JpaRepository<Loan, Long>{

}
