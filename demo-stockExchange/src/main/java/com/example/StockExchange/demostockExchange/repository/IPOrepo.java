package com.example.StockExchange.demostockExchange.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.StockExchange.demostockExchange.entity.IPODetail;

public interface IPOrepo extends JpaRepository<IPODetail, Long> {

	@Query("select i from IPODetail i")
	public List<IPODetail> findAllIPO();
	
	@Query("select i from IPODetail i where i.id=?1")
	public IPODetail findingIPO(Long id);

	@Query("select i from IPODetail i where i.openDateTime =?1")
	public List<IPODetail> findIPOByDate(Date d);
}
