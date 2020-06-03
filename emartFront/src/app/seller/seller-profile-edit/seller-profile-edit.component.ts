import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Seller } from '../../class/seller';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-seller-profile-edit',
  templateUrl: './seller-profile-edit.component.html',
  styleUrls: ['./seller-profile-edit.component.scss']
})
export class SellerProfileEditComponent implements OnInit {

  seller:Seller;

  confirmPassword:string;

  userId:string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {

    this.userId = sessionStorage.getItem('login_user_id')

    this.userService.getSeller(this.userId).subscribe((data:Seller)  => {
      this.seller = data;
    });
  }

  public profileEdit() {

    if(this.seller.password == this.confirmPassword) {
      
      this.userService.sellerSave(this.seller).subscribe( (data:boolean)  => {
        var returnRev = data;

        // Seller Save OK
        if(returnRev){
          alert("Profile Edit OK.");
            this.router.navigateByUrl("/seller")
        } else {
          alert("Profile Edit Falure. \n Please input currect!");
        }
      });

    } else {
      alert("Password not match");
    }
  }

}
