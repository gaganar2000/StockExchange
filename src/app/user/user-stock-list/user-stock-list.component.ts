import { Component, OnInit } from '@angular/core';
import { StockExchange } from 'src/app/models/StockExchange';
import { AdminStockExchangeService } from 'src/app/services/admin-stock-exchange.service';

@Component({
  selector: 'app-user-stock-list',
  templateUrl: './user-stock-list.component.html',
  styleUrls: ['./user-stock-list.component.css']
})
export class UserStockListComponent implements OnInit {

  stk : StockExchange[] = [];
  constructor(private service : AdminStockExchangeService) { }

  ngOnInit(): void {
    this.service.getAllStockExchange().subscribe(data =>{
      this.stk = data;
    });
  }
}
