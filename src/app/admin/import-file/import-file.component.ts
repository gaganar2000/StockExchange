import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StockPrice } from 'src/app/models/StockPrice';
import { AdminIPODetailService } from 'src/app/services/admin-ipodetail.service';
import { AdminStockExchangeService } from 'src/app/services/admin-stock-exchange.service';
import { FlashMessagesService } from 'angular2-flash-messages';
@Component({
  selector: 'app-import-file',
  templateUrl: './import-file.component.html',
  styleUrls: ['./import-file.component.css']
})
export class ImportFileComponent implements OnInit {

  stockPrice : StockPrice[]=[];
  text: string='';
  splited ?: any;
  isUpload : boolean = false;
  constructor(private service : AdminStockExchangeService, private services : AdminIPODetailService, private route : Router, private flash : FlashMessagesService) { 

  }

  ngOnInit(): void {
    this.services.getStockPrice().subscribe(data =>{
      this.stockPrice = data;
    });
  }

  handleUpload(e:any):void{
    this.text = e.target.value; 
    console.log(this.text);
    this.splited = this.text.split("\\");
    console.log(this.splited);
    console.log(this.splited[2]);
    this.service.sendExcelfile(this.splited[2]).subscribe();
    this.flash.show('Data inserted successfully',{
          cssClass :'alert-success',
          timeout : 3000
        });
        this.services.getStockPrice().subscribe(data =>{
      this.stockPrice = data;
    });
    // this.route.navigate(['/admin/import-file']);
  }

}
