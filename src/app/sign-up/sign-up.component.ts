import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { UserService } from '../services/user.service';
import { FlashMessagesService } from 'angular2-flash-messages';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  user : User = {};
  registerMessage : string = '';
  isSent : boolean = false;
  constructor(private service : UserService , private flash : FlashMessagesService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.flash.show('Verification Link sent to your email',{
          cssClass :'alert-success',
          timeout : 3000
        });

    this.service.signupUser(this.user).subscribe(data => {
    });
  }

}
