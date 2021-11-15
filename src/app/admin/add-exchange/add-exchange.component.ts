import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StockExchange } from 'src/app/models/StockExchange';
import { FlashMessagesService } from 'angular2-flash-messages';
import { AdminStockExchangeService } from 'src/app/services/admin-stock-exchange.service';

@Component({
  selector: 'app-add-exchange',
  templateUrl: './add-exchange.component.html',
  styleUrls: ['./add-exchange.component.css']
})
export class AddExchangeComponent implements OnInit {
  stockExchange : StockExchange ={};
  constructor(private router: Router, private service : AdminStockExchangeService, private flash : FlashMessagesService) { }

  ngOnInit(): void {
  }

  onSubmit(){
      this.service.addStockExchange(this.stockExchange).subscribe(data => {
        this.stockExchange = data;
        this.flash.show('Stock Exchange Added Successfully',{
          cssClass :'alert-success',
          timeout : 3000
        });
        this.router.navigate(['/admin/manage-exchange']);
      });
  }

}
