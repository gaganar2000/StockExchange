import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { StockExchange } from 'src/app/models/StockExchange';
import { AdminCompanyService } from 'src/app/services/admin-company.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FlashMessagesService } from 'angular2-flash-messages'
import { Observable } from 'rxjs';


@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {
  comp : Company={};
  num : any
  
  stockexchange ?: StockExchange;
  Stocklist ?: StockExchange[];
  stock : StockExchange={};
  selected : string = 'BSE';
  constructor(private service : AdminCompanyService,
     private route: ActivatedRoute,
     private router : Router,
     private flash : FlashMessagesService) { }

  ngOnInit(): void {
    this.service.getStockExchange().subscribe( data =>{
      this.Stocklist = data;
      console.log(this.Stocklist);
    });
    }

    onSubmit(){
      this.service.getStockById(this.selected).subscribe( data => {
        this.stock = data;
        this.num = this.stock.id;
        this.comp.stockexchange = [this.stock];
        this.service.addCompany(this.comp,this.num).subscribe( data =>{
        this.comp = data;
        console.log("data from backend");
        console.log(this.comp);
        this.flash.show('Company Added Successfully',{
          cssClass :'alert-success',
          timeout : 3000
        });
        this.router.navigate(['/admin/list-company']);
      });
        // this.comp.stockexchange = [this.stock];
      });
      
    }
  }
