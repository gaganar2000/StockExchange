import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public getAdmin(email : string){
    return this.http.get<User>("http://localhost:8082/user/getAdmin/"+email);
  }

  public signupUser(user : User)
  {
    return this.http.post<string>("http://localhost:8082/user/register",user);
  }
}
