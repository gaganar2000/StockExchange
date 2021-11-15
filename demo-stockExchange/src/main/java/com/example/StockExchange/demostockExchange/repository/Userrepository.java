package com.example.StockExchange.demostockExchange.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.StockExchange.demostockExchange.entity.Users;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface Userrepository extends CrudRepository<Users, String> {

	@Query("select u from Users u where u.email=?1")
    Users findByEmailIdIgnoreCase(String emailId);
}

