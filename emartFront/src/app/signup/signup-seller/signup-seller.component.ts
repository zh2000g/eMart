import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Seller } from '../../class/seller';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-signup-seller',
  templateUrl: './signup-seller.component.html',
  styleUrls: ['./signup-seller.component.scss']
})
export class SignupSellerComponent implements OnInit {

  seller:Seller = new Seller();

  confirmPassword : string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  public signUp() {

    if(this.seller.password == this.confirmPassword) {
      
      this.userService.sellerSave(this.seller).subscribe( (data:boolean)  => {
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
