import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
email :string = '';
password :string = '';
isValid?:boolean = false;
error?:boolean = false;
user ?: User;
  constructor(private route: ActivatedRoute,private router : Router, private service: UserService) { }

  ngOnInit(): void {

  }
  onSubmit()
  {

    this.service.getAdmin(this.email).subscribe( data =>{
      this.user = data;
      if(this.email == this.user?.email && this.password== this.user.password && this.user.admin == true)
    {
      this.isValid = true;
    }
    if(this.isValid)
    {
      //this.router.navigate(['add-company'], { relativeTo : this.route});
      this.router.navigate(['/admin/list-company']);
    }
    else{
        this.error = true;
    }
    });

    
  }

}
