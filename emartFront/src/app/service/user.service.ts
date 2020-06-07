import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { Seller } from '../class/seller';
import { Buyer } from '../class/buyer';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // User Login
  public login(user_kind:string, user_id:string, password:string): Observable<HttpResponse<Object>> {

    var url:string = "http://localhost:8050/user/login?userKind=" + 
            user_kind + 
            "&userId=" +
            user_id +
            "&password=" +
            password;

    return this.http.get(url, { observe: 'response' });
  }

  // Buyer Sign Up
  public buyerSave(buyer:Buyer): Observable<boolean> {
    var url:string = "http://localhost:8050/user/buyerSignUp";

     return this.http.post<boolean>(url, buyer);
  }

  
  // Seller Sign Up
  public sellerSave(seller:Seller): Observable<boolean> {
    var url:string = "http://localhost:8050/user/sellerSignUp";

     return this.http.post<boolean>(url, seller);
  }

    // Get Seller infomation
    public getSeller(user_id:string): Observable<Seller> {
      var url:string = "http://localhost:8050/user/getSeller?userId=" + user_id;
  
       return this.http.get<Seller>(url);
    }
}
