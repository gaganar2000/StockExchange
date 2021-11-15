import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IPODetail } from 'src/app/models/IPODetail';
import { AdminIPODetailService } from 'src/app/services/admin-ipodetail.service';
import { FlashMessagesService } from 'angular2-flash-messages';
@Component({
  selector: 'app-update-ipos',
  templateUrl: './update-ipos.component.html',
  styleUrls: ['./update-ipos.component.css']
})
export class UpdateIposComponent implements OnInit {

  ipodetail : IPODetail = {};
  constructor(private router:Router, private route : ActivatedRoute, private service: AdminIPODetailService, private flash : FlashMessagesService) { }

  ngOnInit(): void {
    this.service.getIPOById(this.route.snapshot.params.id).subscribe(data=>{
      this.ipodetail = data;
    });
  }

  onSubmit(){
    this.service.editIPO(this.route.snapshot.params.id,this.ipodetail).subscribe(data => {
      this.ipodetail = data;
      this.flash.show('IPO Details Updated Successfully',{
          cssClass :'alert-success',
          timeout : 3000
        });
      this.router.navigate(['admin/list-ipo']);
    });
  }


}
