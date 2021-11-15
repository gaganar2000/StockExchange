import { Component, OnInit } from '@angular/core';
import { IPODetail } from 'src/app/models/IPODetail';
import { AdminIPODetailService } from 'src/app/services/admin-ipodetail.service';

@Component({
  selector: 'app-user-ipolist',
  templateUrl: './user-ipolist.component.html',
  styleUrls: ['./user-ipolist.component.css']
})
export class UserIPOListComponent implements OnInit {

  ipoList : IPODetail[]=[];
  constructor(private service: AdminIPODetailService) { }

  ngOnInit(): void {
    this.service.getAllIPODetail().subscribe(data => {
      this.ipoList = data;
    });
  }
}
