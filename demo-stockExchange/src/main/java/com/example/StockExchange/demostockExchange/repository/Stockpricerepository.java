package com.example.StockExchange.demostockExchange.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.StockExchange.demostockExchange.entity.Company;
import com.example.StockExchange.demostockExchange.entity.StockPrice;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface Stockpricerepository extends JpaRepository<StockPrice,Long>{
	
	@Query("select s from StockPrice s")
	public List<StockPrice> findAllStockPrice();
	
	@Query("select s from StockPrice s where s.companycode = ?1 and (s.datee between ?2 and ?3)")
	public List<StockPrice> getChartStock(String companycode, Date fromDate, Date toDate);
}