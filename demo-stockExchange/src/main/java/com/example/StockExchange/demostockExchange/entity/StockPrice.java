package com.example.StockExchange.demostockExchange.entity;

import java.util.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String companycode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private StockExchange stockexchange;
	
	private float shareprice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Company company;
	
	private Date datee;
	private String time;

	public StockExchange getStockexchange() {
		return stockexchange;
	}
	public void setStockexchange(StockExchange stockexchange) {
		this.stockexchange = stockexchange;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getCompanycode() {
		return companycode;
	}
	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public Date getDatee() {
		return datee;
	}
	
	public void setDatee(Date datee) {
		this.datee = datee;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public float getShareprice() {
		return shareprice;
	}
	public void setShareprice(float shareprice) {
		this.shareprice = shareprice;
	}
	public StockPrice(long id, String companycode, Date datee,String time, float shareprice) {
		super();
		this.id = id;
		this.companycode = companycode;
		this.datee = datee;
		this.time = time;
		this.shareprice = shareprice;
	}
	
	public StockPrice(long id, String companycode,Company company,Date datee, String timee, float shareprice) {
		super();
		this.id = id;
		this.companycode = companycode;
		this.company = company;
		this.datee = datee;
		this.time = timee;
		this.shareprice = shareprice;
	}
	
	public StockPrice() {
		
	}
	
}
