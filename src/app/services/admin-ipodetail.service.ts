import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IPODetail } from '../models/IPODetail';
import { StockPrice } from '../models/StockPrice';

@Injectable({
  providedIn: 'root'
})
export class AdminIPODetailService {

  constructor(private http: HttpClient) { }

  public getAllIPODetail(){
    return this.http.get<IPODetail[]>("http://localhost:8082/IPODetail/getAll")
  }

  public getIPOById(id : number){
    return this.http.get<IPODetail>("http://localhost:8082/IPODetail/getbyId/"+id);
  }

  public addIPO(data : IPODetail)
  {
    return this.http.post<IPODetail>("http://localhost:8082/IPODetail/add",data);
  }

  public editIPO(id: number, ipo : IPODetail)
  {
    return this.http.put<IPODetail>("http://localhost:8082/IPODetail/edit/"+id, ipo);
  }

  public getStockPrice()
  {
    return this.http.get<StockPrice[]>("http://localhost:8082/stockPrice/getAllStockPrices");
  }

  public getChart(date : String){
    return this.http.get<IPODetail[]>("http://localhost:8082/IPODetail/chart/"+date);
  }
}
