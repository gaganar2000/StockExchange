import { Component, OnInit } from '@angular/core';
import { AdminIPODetailService } from 'src/app/services/admin-ipodetail.service';
import { StockPrice } from 'src/app/models/StockPrice';


@Component({
  selector: 'app-stock-price',
  templateUrl: './stock-price.component.html',
  styleUrls: ['./stock-price.component.css']
})
export class StockPriceComponent implements OnInit {

stockPrice : StockPrice[] =[];
  constructor(private service : AdminIPODetailService) { }

  ngOnInit(): void {
    this.service.getStockPrice().subscribe(data =>{
      this.stockPrice = data;
    });
  }

}
