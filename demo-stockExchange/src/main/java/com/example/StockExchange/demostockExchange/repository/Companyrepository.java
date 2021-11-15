package com.example.StockExchange.demostockExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StockExchange.demostockExchange.entity.Company;
import com.example.StockExchange.demostockExchange.entity.StockExchange;

import javax.transaction.Transactional;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.catalina.Store;
import org.springframework.stereotype.Repository;

//import com.stockexchange.phase3.*;

import javassist.bytecode.SignatureAttribute.BaseType;

import org.springframework.data.repository.CrudRepository;
@Repository
@Transactional
public class Companyrepository {

	@PersistenceContext
	EntityManager entityManager;
//	public Company savecompany(String companyName, Double turnover, String ceo, String boardOfDirectors,String companyBrief) {
//		Company cmp = new Company(companyName,turnover, ceo,boardOfDirectors,companyBrief);
//		entityManager.persist(cmp);
//		return cmp;
//	}
	

	
	public Company savecompany(Long id,String Name) {
		Company cmp = new Company(id, Name);
		entityManager.persist(cmp);
		return cmp;
	}
	
	public Company savecompany(Company c) {
		 entityManager.persist(c);
		return c;
	}
	
	
	public Company findcompany(Company c) {
		Company cmp = new Company();
		cmp = entityManager.find(Company.class,c);
		return cmp;
	}

	
	public List<Company> findcompanylist() {
		Query q1 = entityManager.createQuery(" select c from Company c", Company.class);       
		return q1.getResultList();
	
	}
		
	public StockExchange findexchange(StockExchange stockexchange) {
		StockExchange cmp = new StockExchange();
		cmp = entityManager.find(StockExchange.class,stockexchange);
		return cmp;
	}

}