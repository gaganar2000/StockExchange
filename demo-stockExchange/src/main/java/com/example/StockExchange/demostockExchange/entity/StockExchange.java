package com.example.StockExchange.demostockExchange.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StockExchange {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String brief;
	private String address;
	private String city;
	private String country;
	private String remarks;
	
//	@OneToMany(targetEntity = Companystockexchangemap.class)
//	private List<Companystockexchangemap> compstockmap;
	
	public String getBrief() {
		return brief;
	}


	public void setBrief(String brief) {
		this.brief = brief;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@ManyToMany
	@JoinTable(name="COMPANY_STOCKEXCHANGE",
	joinColumns = @JoinColumn(name="STOCKEXCHANGE_ID"), inverseJoinColumns = @JoinColumn(name="COMPANY_ID"))
	@JsonIgnore
	private List<Company> company = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="IPODETAIL_STOCKEXCHANGE",
	joinColumns = @JoinColumn(name="STOCKEXCHANGE_ID"), inverseJoinColumns = @JoinColumn(name="IPODETAIL_ID"))
	@JsonIgnore
	private List<IPODetail> ipoDetail = new ArrayList<>();
	
	@OneToMany(mappedBy  = "stockexchange")
	private List<StockPrice> stockprice = new ArrayList<>();
	
	
	public List<Company> getCompany() {
		return company;
	}
	
	
	public List<IPODetail> getIpoDetail() {
		return ipoDetail;
	}
	public void setIpoDetail(List<IPODetail> ipoDetail) {
		this.ipoDetail = ipoDetail;
	}
	public List<StockPrice> getStockprice() {
		return stockprice;
	}
	public void setStockprice(List<StockPrice> stockprice) {
		this.stockprice = stockprice;
	}
	public void setCompany(List<Company> company) {
		this.company = company;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public StockExchange() {
		
	}


public StockExchange(long id, String name, String brief, String address, String city, String country, String remarks,
		List<Company> company, List<IPODetail> ipoDetail, List<StockPrice> stockprice) {
	super();
	this.id = id;
	this.name = name;
	this.brief = brief;
	this.address = address;
	this.city = city;
	this.country = country;
	this.remarks = remarks;
	this.company = company;
	this.ipoDetail = ipoDetail;
	this.stockprice = stockprice;
}
	
	
}
