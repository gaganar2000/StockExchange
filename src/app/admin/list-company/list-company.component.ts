import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { Observable } from 'rxjs';
import { AdminCompanyService } from 'src/app/services/admin-company.service';

@Component({
  selector: 'app-list-company',
  templateUrl: './list-company.component.html',
  styleUrls: ['./list-company.component.css']
})
export class ListCompanyComponent implements OnInit {

  comp : Company[] = [];
  constructor(private service : AdminCompanyService) { }

  ngOnInit(): void {
    this.service.getCompanyList().subscribe( data => {
      this.comp = data;
      console.log(this.comp);
    });

  }
}
