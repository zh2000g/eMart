import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Buyer } from '../../class/buyer';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-signup-buyer',
  templateUrl: './signup-buyer.component.html',
  styleUrls: ['./signup-buyer.component.scss']
})
export class SignupBuyerComponent implements OnInit {

  buyer:Buyer = new Buyer();

  confirmPassword : string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  public signUp() {

    if(this.buyer.password == this.confirmPassword) {
      
      this.userService.buyerSave(this.buyer).subscribe( (data:boolean)  => {
        var returnRev = data;

        // Login OK
        if(returnRev){
          alert("Sign Up OK. \n Please Login.");
            this.router.navigateByUrl("/login")
        } else {
          alert("Sign Up Falure. \n Please input currect!");
        }
      });
      
    } else {
      alert("Password not match");
    }
  }

}
