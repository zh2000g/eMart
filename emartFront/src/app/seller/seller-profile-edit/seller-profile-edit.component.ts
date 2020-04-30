import { Component, OnInit } from '@angular/core';
import { Seller } from '../../class/seller';
import { SellerService } from '../../service/seller.service';

@Component({
  selector: 'app-seller-profile-edit',
  templateUrl: './seller-profile-edit.component.html',
  styleUrls: ['./seller-profile-edit.component.scss']
})
export class SellerProfileEditComponent implements OnInit {

  seller:Seller;

  constructor(private sellerService: SellerService) { }

  ngOnInit(): void {
    this.seller = this.sellerService.getSellerInfo("user007");
  }

}
