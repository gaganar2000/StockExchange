import { Component, OnInit } from '@angular/core';
import { IPODetail } from 'src/app/models/IPODetail';
import { AdminIPODetailService } from 'src/app/services/admin-ipodetail.service';
import  Chart  from 'chart.js/auto';
@Component({
  selector: 'app-company-chart',
  templateUrl: './company-chart.component.html',
  styleUrls: ['./company-chart.component.css']
})
export class CompanyChartComponent implements OnInit {

  show ?: boolean = false;
  date : Date = new Date();
  d : string='';
  data: IPODetail[] =[];  
  Company = [] as any;  
  Share = [] as any;  
  barchart = [] as any; 
  fromDate : Date = new Date();
  toDate : Date = new Date();
  companyCode : string = '';
  constructor(private service : AdminIPODetailService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.d = this.date.toString();
    this.service.getChart(this.d).subscribe((result: IPODetail[] ) => {  
        result.forEach( x => {
          this.Company.push(x.company?.companyName)
          this.Share.push(x.pricePerShare)
        });
        this  
        this.barchart = new Chart('canvas', {  
          type: 'bar',  
          data: {  
            labels: this.Company,  
            datasets: [  
              {  
                data: this.Share,  
                borderColor: '#3cba9f',  
                backgroundColor: [  
                  "#3cb371",  
                  "#0000FF",  
                  "#9966FF",  
                  "#4C4CFF",  
                  "#00FFFF",  
                  "#f990a7",  
                  "#aad2ed",  
                  "#FF00FF",  
                  "Blue",  
                  "Red",  
                  "Blue"  
                ],
              }  
            ]  
          }
        });  
      });   
      this.show = true;
    }

    onSubmit1(){
      
    }


    // this.service.getChart(this.d).subscribe(data =>
    //   {
    //     this.ipodetail = data;
    //     console.log(this.ipodetail);
    //   });


}
