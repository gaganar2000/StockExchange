package com.example.StockExchange.demostockExchange.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQuery(name = "Company.findByname", query = "SELECT c FROM Company c WHERE c.companyName = :name")
@javax.persistence.Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String companyName;

	@Column(nullable = false)
	private Double turnover;

	@Column(nullable = false)
	private String ceo;

	@Column(nullable = false)
	@Type(type = "text")
	private String boardOfDirectors;

	@Column(nullable = false)
	@Type(type = "text")
	private String companyBrief;

//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REMOVE)
//	private IPODetail ipo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private IPODetail ipodetail;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="company")
	@JsonIgnore
	private List<StockPrice> stockprice = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy="company")
	private List<StockExchange> stockexchange = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Sector sector;
	
	
//	@OneToMany(fetch = FetchType.LAZY,targetEntity = Companystockexchangemap.class)
//	private List<Companystockexchangemap> compstockmap;
	
	public IPODetail getIpodetail() {
		return ipodetail;
	}

	public void setIpodetail(IPODetail ipodetail) {
		this.ipodetail = ipodetail;
	}

	public List<StockPrice> getStockprice() {
		return stockprice;
	}

	public void setStockprice(List<StockPrice> stockprice) {
		this.stockprice = stockprice;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	
	public Company() {
		
	}

	public Company(Long id, String companyName, Double turnover, String ceo, String boardOfDirectors,List<StockExchange> s,
			String companyBrief) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.companyBrief = companyBrief;
		this.stockexchange = s;
	}
	
	public List<StockExchange> getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(List<StockExchange> stockexchange) {
		this.stockexchange = stockexchange;
	}

//	public Sector getSector() {
//		return sector;
//	}
//
//	public void setSector(Sector sector) {
//		this.sector = sector;
//	}

	public Company(String name)
	{
		this.companyName = name;
	}
	
	public Company(Long id,String name)
	{
		this.id = id;
		this.companyName = name;
	}
	
	public Company( String companyName, Double turnover, String ceo, String boardOfDirectors,String companyBrief,List<StockExchange> s) {
		super();
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.companyBrief = companyBrief;
		this.stockexchange = s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getCompanyBrief() {
		return companyBrief;
	}

	public void setCompanyBrief(String companyBrief) {
		this.companyBrief = companyBrief;
	}

//
//	public List<StockPrice> getStockprice() {
//		return stockprice;
//	}
//
//	public void setStockprice(List<StockPrice> stockprice) {
//		this.stockprice = stockprice;
//	}

}


