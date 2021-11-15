package com.example.StockExchange.demostockExchange.controller;

import java.net.URI;
import java.util.ArrayList;
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
import com.example.StockExchange.demostockExchange.entity.Company;
import com.example.StockExchange.demostockExchange.entity.IPODetail;
import com.example.StockExchange.demostockExchange.entity.StockExchange;
import com.example.StockExchange.demostockExchange.repository.Companyrepository;
import com.example.StockExchange.demostockExchange.repository.Companyrepository2;
import com.example.StockExchange.demostockExchange.repository.StockExchangerepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/company")
public class CompanystockexchangeController  {

	@Autowired
	Companyrepository cmprep;
	@Autowired
	Companyrepository2 cmprep2;

	@Autowired
	StockExchangerepository stkrep;
	

	
	@PostMapping("/insert/{id}")
	public Company insertCompany(@RequestBody Company c,@PathVariable Long id)
	{ 
//		    System.out.println(c.getCeo());
//		    for(StockExchange s : c.getStockexchange()) {
//		    	System.out.println(s.getName());
//		    }
			StockExchange se = stkrep.findingById(id);
			List<StockExchange> list = new ArrayList<>();
			list.add(se);
			Company cmp = new Company();
			cmp.setBoardOfDirectors(c.getBoardOfDirectors());
			cmp.setCeo(c.getCeo());
			cmp.setCompanyBrief(c.getCompanyBrief());
			cmp.setCompanyName(c.getCompanyName());
			cmp.setTurnover(c.getTurnover());
			cmp.setStockexchange(c.getStockexchange());
			Company comp = cmprep2.save(cmp); 
			return comp;
	}
	
	
	
	@GetMapping("/getAll")
	public List<Company> getAllCompany(){
		return cmprep2.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Company getCompanyById(@PathVariable Long id) {
		Company cmp = cmprep2.findingById(id);
		return cmp;
	}
	
	@PutMapping("/edit/{id}")
	public Company editCompany(@RequestBody Company c,@PathVariable Long id)
	{ 
		    Company cmp = cmprep2.getOne(id);
		    cmp.setBoardOfDirectors(c.getBoardOfDirectors());
			cmp.setCeo(c.getCeo());
			cmp.setCompanyBrief(c.getCompanyBrief());
			cmp.setCompanyName(c.getCompanyName());
			cmp.setTurnover(c.getTurnover());
			cmp.setStockexchange(c.getStockexchange());
			cmp = cmprep2.save(cmp);
			
			return cmp;
	}
	
	
	public Company getCompany(Long id)
	{
		Company cmp = cmprep2.findingById(id);
		return cmp;
	}


}
