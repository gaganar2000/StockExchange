package com.example.StockExchange.demostockExchange.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.StockExchange.demostockExchange.entity.StockExchange;
import com.example.StockExchange.demostockExchange.repository.StockExchangerepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/stockexchange")
public class  StockExchangecontroller {
	@Autowired
	StockExchangerepository stkrep;
	
	@PostMapping("/saveadd")
	public StockExchange saveadd(@RequestBody StockExchange st) {
		st = stkrep.save(st);
		return st;
	}
	
	@GetMapping("/getAll")
	public List<StockExchange> getStockexchange()
	{
		return stkrep.findAll();
	}
	
	@PutMapping("/edit/{id}")
	public StockExchange editStockExchange(@RequestBody StockExchange se,@PathVariable Long id)
	{
		StockExchange s = stkrep.getOne(id);
		s.setName(se.getName());
		s.setAddress(se.getAddress());
		s.setCity(se.getCity());
		s.setCountry(se.getCountry());
		s.setRemarks(se.getRemarks());
		s.setBrief(se.getBrief());
		s = stkrep.save(s);
		return s;
	}
	
	
	@GetMapping("/getById/{id}")
	public StockExchange getStockById(@PathVariable Long id)
	{
		return stkrep.findingById(id);
	}
	
	@GetMapping("/getByName/{name}")
	public StockExchange getStockByName(@PathVariable String name)
	{
		return stkrep.findingByName(name);
	}
	
	public StockExchange getStockExchange(String name)
	{
		return stkrep.findingByName(name);
	}
}