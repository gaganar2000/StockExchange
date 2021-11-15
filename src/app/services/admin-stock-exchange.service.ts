import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StockExchange } from '../models/StockExchange';
import { StockPrice } from '../models/StockPrice';
@Injectable({
  providedIn: 'root'
})
export class AdminStockExchangeService {

  constructor(private http: HttpClient) { }

  public getAllStockExchange(){
    return this.http.get<StockExchange[]>("http://localhost:8082/stockexchange/getAll")
  }

  public getStockById(id : number){
    return this.http.get<StockExchange>("http://localhost:8082/stockexchange/getById/"+id);
  }

  public addStockExchange(data : StockExchange)
  {
    return this.http.post<StockExchange>("http://localhost:8082/stockexchange/saveadd",data);
  }

  public editStockExchange(id: number, stk : StockExchange)
  {
    return this.http.put<StockExchange>("http://localhost:8082/stockexchange/edit/"+id,stk);
  }

  public sendExcelfile(filepath: string)
  {
    return this.http.post<StockPrice[]>("http://localhost:8082/stockPrice/importExcel/"+filepath, null);
  }
  
}
