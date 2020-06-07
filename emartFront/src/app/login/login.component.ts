import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router} from '@angular/router';

import { UserService } from '../service/user.service';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user_kind:string = "1";
  user_id : string;
  password: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  // User Login
  public login() {

    this.userService.login(this.user_kind, this.user_id, this.password).subscribe( res => {
      const keys = res.headers.keys();

      var returnRev = res.body;

      // Login OK
      if(returnRev){
        sessionStorage.setItem('login_user_id',this.user_id);
        sessionStorage.setItem('token',"token");

        if(this.user_kind == "1") {
          this.router.navigateByUrl("/searchList")
        } else {
          this.router.navigateByUrl("/seller")
        }
      } else {
        alert("Login Falure. \n Please input currect!");
      }

    });


  }

}
