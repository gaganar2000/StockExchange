package com.example.StockExchange.demostockExchange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.StockExchange.demostockExchange.entity.Company;
import com.example.StockExchange.demostockExchange.entity.StockExchange;

import org.springframework.data.repository.CrudRepository;
@Repository
@Service
public interface StockExchangerepository extends JpaRepository<StockExchange, Long> {
	
	@Query("select c from StockExchange c where c.id=?1")
	public StockExchange findingById(Long id);
	
	@Query("select c from StockExchange c where c.name=?1")
	public StockExchange findingByName(String name);
	
}