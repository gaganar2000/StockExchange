import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';
@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  email :string = '';
  password?:string = '';
  isValid?:boolean = false;
  error?:boolean = false;
  user : User={};
    constructor(private route: ActivatedRoute,private router : Router, private service : UserService) { }
  
    ngOnInit(): void {
  
    }
    onSubmit()
    {
      this.service.getAdmin(this.email).subscribe(data => {
        this.user = data;
        console.log(this.user);
        if(this.email ==this.user.email && this.password==this.user.password && this.user.confirmed==true)
      {
        this.isValid = true;
      }
      if(this.isValid)
      {
        //this.router.navigate(['add-company'], { relativeTo : this.route});
        this.router.navigate(['/user/list-company']);
      }
      else{
          this.error = true;
      }
      });
    }
      
}
