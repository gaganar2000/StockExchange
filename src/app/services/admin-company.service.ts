import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Company } from '../models/Company';
import { StockExchange } from '../models/StockExchange';
@Injectable({
  providedIn: 'root'
})
export class AdminCompanyService {
  private companyUrl : string='';

  constructor(private http: HttpClient) {
    this.companyUrl = 'http://localhost:8082/company/getAll';
   }

  public getCompanyList()
  {
    return this.http.get<Company[]>(this.companyUrl);
  }

  public getCompanyById(id: number)
  {
    return this.http.get<Company>("http://localhost:8082/company/getById/"+id);
  }

  public getStockExchange(){
  return this.http.get<StockExchange[]>("http://localhost:8082/stockexchange/getAll");
  }

  public getStockById(name: string)
  {
    return this.http.get<StockExchange>("http://localhost:8082/stockexchange/getByName/"+name);
  }
  
  public addCompany(comp : Company, id :number)
  {
    console.log("backend");
    console.log(comp);
    return this.http.post("http://localhost:8082/company/insert/"+id,comp);
  }
  
  public editCompany(id : number, comp: Company)
  {
    return this.http.put<Company>("http://localhost:8082/company/edit/"+id,comp);
  }
}