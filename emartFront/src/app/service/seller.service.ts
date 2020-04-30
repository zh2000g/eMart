import { Injectable } from '@angular/core';
import { Seller } from '../class/seller';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  seller:Seller;

  constructor() { 
    this.seller = new Seller();
  }

  getSellerInfo(user_id:string):any {
    this.seller.user_id="user007";
    this.seller.user_name="john";
    this.seller.password = "123456";
    this.seller.confirm_password = "123456";
    this.seller.company_name = "IBM";
    this.seller.brief_of_company = "IBM is a IT solution company";
    this.seller.gstin = "gstin_number";
    this.seller.post_address = "New York of America";
    this.seller.website = "http://www.ibm.com";
    this.seller.email = "test@ibm.com";
    this.seller.contract_number = "1234-5678-90";

    return this.seller;
  
  }
}
