import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Seller } from '../class/seller';
import { stringify } from 'querystring';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  seller:Seller;

  constructor(private http: HttpClient) { 
    this.seller = new Seller();
  }

 
  public getSellerInfo(user_id:string):any {
    var return_val: boolean = false;

    var url = "http://localhost:8050/user/login?userKind=2&userId=seller1&password=12345";

    this.http.get(url).subscribe( (data:boolean) => {
      return_val = data;
    });

    return this.seller;
  
  }
}
