import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IPODetail } from 'src/app/models/IPODetail';
import { FlashMessagesService } from 'angular2-flash-messages';
import { AdminIPODetailService } from 'src/app/services/admin-ipodetail.service';

@Component({
  selector: 'app-add-ipos',
  templateUrl: './add-ipos.component.html',
  styleUrls: ['./add-ipos.component.css']
})
export class AddIposComponent implements OnInit {

  ipodetail : IPODetail = {};
  constructor(private router: Router, private service:AdminIPODetailService, private flash : FlashMessagesService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.service.addIPO(this.ipodetail).subscribe( data =>{
      this.ipodetail = data;
      this.flash.show('IPO Detail Added Successfully',{
          cssClass :'alert-success',
          timeout : 3000
        });
        this.router.navigate(['/admin/list-ipo']);
    });
    
  }

}
