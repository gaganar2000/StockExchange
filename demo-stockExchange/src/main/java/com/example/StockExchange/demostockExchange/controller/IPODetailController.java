package com.example.StockExchange.demostockExchange.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StockExchange.demostockExchange.entity.IPODetail;
import com.example.StockExchange.demostockExchange.repository.IPOrepo;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/IPODetail")
public class IPODetailController {
	
	@Autowired
	IPOrepo iporep;
	
	@GetMapping("/getAll")
	public List<IPODetail> getIPODetail()
	{
		return iporep.findAllIPO();
	}
	
	@GetMapping("/getbyId/{id}")
	public IPODetail getIPObyId(@PathVariable Long id)
	{
		return iporep.findingIPO(id);
	}
	
	@PostMapping("/add")
	public IPODetail addIPO(@RequestBody IPODetail ipo)
	{
		IPODetail ipod = iporep.save(ipo);
		return ipod;
	}
	
	@PutMapping("/edit/{id}")
	public IPODetail editIPO(@RequestBody IPODetail ipo, @PathVariable Long id)
	{
		IPODetail ipod = iporep.getOne(id);
		ipod.setOpenDateTime(ipo.getOpenDateTime());
		ipod.setPricePerShare(ipo.getPricePerShare());
		ipod.setRemarks(ipo.getRemarks());
		ipod.setTotalNumberOfShares(ipo.getTotalNumberOfShares());
		ipod = iporep.save(ipod);
		return ipod;
	}
	
	@GetMapping("/chart/{date}")
	public List<IPODetail> getChart(@PathVariable String date) throws Exception
	{
		Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		return iporep.findIPOByDate(d);
	}
	

}
