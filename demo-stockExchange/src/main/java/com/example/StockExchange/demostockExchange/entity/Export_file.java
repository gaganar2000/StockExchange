package com.example.StockExchange.demostockExchange.entity;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.StockExchange.demostockExchange.controller.CompanystockexchangeController;
import com.example.StockExchange.demostockExchange.controller.StockExchangecontroller;
import com.example.StockExchange.demostockExchange.controller.Stockpricecontroller;
import com.example.StockExchange.demostockExchange.repository.Companyrepository2;
import com.example.StockExchange.demostockExchange.repository.StockExchangerepository;
import com.example.StockExchange.demostockExchange.repository.Stockpricerepository;

public class Export_file {
	
	@Autowired
	private Stockpricerepository stkp;
	@Autowired
	private StockExchangerepository stke;
	@Autowired
	private Companyrepository2 cmpc;
	
	public List<StockPrice> excelImport(String file)
	{
		String stockexchange = null;
		List<StockPrice> stockPrice = new ArrayList<>();
		Company c = new Company();
		StockExchange stk = new StockExchange();
		
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(file));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();
			rowIterator.next();
			
			while(rowIterator.hasNext()) {

				StockPrice s = new StockPrice();
				
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while(cellIterator.hasNext()) {					
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					switch(columnIndex) {
					case 0:
						s.setCompanycode(nextCell.getStringCellValue());
						System.out.println(s.getCompanycode());
						break;
					case 1:
						stockexchange = nextCell.getStringCellValue();
						System.out.println(stockexchange);
						break;
					case 2:
						s.setShareprice((float)nextCell.getNumericCellValue());
						System.out.println(s.getShareprice());
					case 3:
						s.setDatee((Date)nextCell.getDateCellValue());
						System.out.println(s.getDatee());
						break;
					case 4:
						s.setTime((String)nextCell.getStringCellValue());
						System.out.println(s.getTime());
						break;
					}
				}
				stockPrice.add(s);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		return stockPrice;
	}
}
