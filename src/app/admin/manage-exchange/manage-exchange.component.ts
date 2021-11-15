import { Component, OnInit } from '@angular/core';
import { StockExchange } from 'src/app/models/StockExchange';
import { AdminStockExchangeService } from 'src/app/services/admin-stock-exchange.service';

@Component({
  selector: 'app-manage-exchange',
  templateUrl: './manage-exchange.component.html',
  styleUrls: ['./manage-exchange.component.css']
})
export class ManageExchangeComponent implements OnInit {
stk : StockExchange[] = [];
  constructor(private service : AdminStockExchangeService) { }

  ngOnInit(): void {
    this.service.getAllStockExchange().subscribe(data =>{
      this.stk = data;
    })
  }

}
