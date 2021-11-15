import { Component, OnInit } from '@angular/core';
import { StockExchange } from 'src/app/models/StockExchange';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminStockExchangeService } from 'src/app/services/admin-stock-exchange.service';
import { FlashMessagesService } from 'angular2-flash-messages';
@Component({
  selector: 'app-update-exchange',
  templateUrl: './update-exchange.component.html',
  styleUrls: ['./update-exchange.component.css']
})
export class UpdateExchangeComponent implements OnInit {

  stockExchange : StockExchange={};
  constructor(private route: ActivatedRoute, private router: Router, private service: AdminStockExchangeService, private flash : FlashMessagesService) { }

  ngOnInit(): void {
    this.service.getStockById(this.route.snapshot.params.id).subscribe(result =>{
      this.stockExchange = result;
    });
  }

  onSubmit(){
    this.service.editStockExchange(this.route.snapshot.params.id,this.stockExchange).subscribe( data =>{
      this.stockExchange = data;
      console.log(this.stockExchange);
      this.flash.show('Stock Exchange Details Updated Successfully',{
          cssClass :'alert-success',
          timeout : 3000
        });
      this.router.navigate(['/admin/manage-exchange']);
    });
  }

}
