import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user_kind:any = "1";
  user_id : string;
  password: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  public login() {
    sessionStorage.setItem('login_user_id',this.user_id);

    if(this.user_kind == 1) {
      
      this.router.navigateByUrl("/searchList")
    } else {
      this.router.navigateByUrl("/seller")
    }
  }

}
