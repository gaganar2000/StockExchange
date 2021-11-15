import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminCompanyService } from 'src/app/services/admin-company.service';
import { FlashMessagesService } from 'angular2-flash-messages';
@Component({
  selector: 'app-edit-company',
  templateUrl: './edit-company.component.html',
  styleUrls: ['./edit-company.component.css']
})
export class EditCompanyComponent implements OnInit {
  comp : Company = {};
  constructor(private router: ActivatedRoute, private service:AdminCompanyService, private route: Router, private flash : FlashMessagesService) { }

  ngOnInit(): void {
    console.log(this.router.snapshot.params.id);
    this.service.getCompanyById(this.router.snapshot.params.id).subscribe((result)=>
    {
      this.comp = result;
    });
  }
  onSubmit(){

    this.service.editCompany(this.router.snapshot.params.id, this.comp).subscribe( data =>{
      this.comp = data;
      console.log("data from backend");
      console.log(this.comp);
      this.flash.show('Company Details Updated Successfully',{
          cssClass :'alert-success',
          timeout : 3000
        });
      this.route.navigate(['/admin/list-company']);
    });

  }

}
