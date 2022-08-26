package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Editorial;

public interface IEditorialDAO extends JpaRepository<Editorial, Long>{

}
