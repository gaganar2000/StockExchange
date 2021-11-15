import { Component, OnInit } from '@angular/core';
import { IPODetail } from 'src/app/models/IPODetail';
import { AdminIPODetailService } from 'src/app/services/admin-ipodetail.service';

@Component({
  selector: 'app-list-ipo',
  templateUrl: './list-ipo.component.html',
  styleUrls: ['./list-ipo.component.css']
})
export class ListIpoComponent implements OnInit {

  ipoList : IPODetail[]=[];
  constructor(private service: AdminIPODetailService) { }

  ngOnInit(): void {
    this.service.getAllIPODetail().subscribe(data => {
      this.ipoList = data;
    });
  }
}
