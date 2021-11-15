import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { AdminCompanyService } from 'src/app/services/admin-company.service';

@Component({
  selector: 'app-user-list-company',
  templateUrl: './user-list-company.component.html',
  styleUrls: ['./user-list-company.component.css']
})
export class UserListCompanyComponent implements OnInit {

  comp : Company[] = [];
  constructor(private service : AdminCompanyService) { }

  ngOnInit(): void {
    this.service.getCompanyList().subscribe( data => {
      this.comp = data;
      console.log(this.comp);
    });
  }
}
