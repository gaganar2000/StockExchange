package com.example.StockExchange.demostockExchange.controller;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.StockExchange.demostockExchange.entity.StockPrice;
import com.example.StockExchange.demostockExchange.entity.Company;
import com.example.StockExchange.demostockExchange.entity.Export_file;
import com.example.StockExchange.demostockExchange.entity.IPODetail;
import com.example.StockExchange.demostockExchange.entity.StockExchange;
import com.example.StockExchange.demostockExchange.repository.Companyrepository2;
import com.example.StockExchange.demostockExchange.repository.StockExchangerepository;
import com.example.StockExchange.demostockExchange.repository.Stockpricerepository;


@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/stockPrice")
public class Stockpricecontroller {
	@Autowired
	Stockpricerepository stkpricerepo;
	@Autowired
	Companyrepository2 cmpr;
	@Autowired
	StockExchangerepository ser;

	@RequestMapping(value = "/addstockprices",method=RequestMethod.POST, headers = "Accept=application/json"  )
	
	public  ResponseEntity<Object> stockpriceapi(@RequestBody StockPrice stockprice) throws AddressException, MessagingException, ClassNotFoundException, IOException {
	
		StockPrice stkprice= stkpricerepo.save(stockprice);
	   // make sure your entity class properties of user are in lower case and match the json,to avoid errors
		System.out.println(stkprice +"check this " +stkprice.getCompanycode());
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stkprice.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
//	@CrossOrigin(origins ="http://localhost:3000")
	//@RequestMapping(value = "/getstockprices",method=RequestMethod.GET, headers = "Accept=application/json"  )
	@GetMapping("/getAllStockPrices")
	public List<StockPrice> getstockprice() throws AddressException, MessagingException, ClassNotFoundException, IOException {
	
		List<StockPrice> stkprice= stkpricerepo.findAllStockPrice();  // make sure your entity class properties of user are in lower case and match the json,to avoid errors
		return stkprice;
	}

	@PostMapping("/importExcel/{file}")
	public List<StockPrice> importExcel(@PathVariable String file)
	{
		String filepath = "C:/Users/Meghana/Downloads/"+file;
		Export_file e = new Export_file();
		List<StockPrice> s = e.excelImport(filepath);
		long m = 1;
		Company c = cmpr.findingById(m);
		StockExchange se = ser.findingByName("BSE");
		int i=0;
		for(StockPrice sp : s)
		{
			sp.setCompany(c);
			sp.setStockexchange(se);
			stkpricerepo.save(sp);
		}
		return s;
	}

	
	public StockPrice saveStock(StockPrice s)
	{
		return stkpricerepo.save(s);
	}
	
	@PostMapping("/chartStock")
	public List<StockPrice> getChartStock(@RequestBody String fromDate,@RequestBody String toDate,@RequestBody String companycode) throws Exception
	{
		Date from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
		Date to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
		return stkpricerepo.getChartStock(companycode, from, to);
	}
	
}