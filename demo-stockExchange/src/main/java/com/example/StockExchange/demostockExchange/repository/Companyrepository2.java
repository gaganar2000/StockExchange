package com.example.StockExchange.demostockExchange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.StockExchange.demostockExchange.entity.Company;

import org.springframework.data.repository.CrudRepository;
@Repository
//public interface Personjparepository2 extends JpaRepository <Person, Long> { }
public interface Companyrepository2  extends JpaRepository<Company, Long> {
	
	
	@Query("select c from Company c")
	public List<Company> findAllCompany();
	
	@Query("select c from Company c where c.id=?1")
	public Company findingById(Long id);
	
}
