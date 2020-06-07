import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { Item } from '../class/item';
import { CartItem } from '../class/cart-item';
import { Deal } from '../class/deal';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  httpOptions:any = {};
  
  constructor(private http: HttpClient) { 
    var token = sessionStorage.getItem('token');

    this.httpOptions = {
      headers: new HttpHeaders({
        'Authorization Bearer ': token
      })

    };
  }

  
  // Get Stock ItemList
  public getStockItemList(user_id:string): Observable<Item[]> {
    
    var url:string = "http://localhost:8050/item/getListBySeller?sellerId=" + user_id;

    return this.http.get<Item[]>(url);
  }

  // Add Item
  public addItem(item:Item): Observable<boolean> {

    var url:string = "http://localhost:8050/item/addItem";

    return this.http.post<boolean>(url, item);
  }

  // Get One Item
  public getItem(item_id:string): Observable<Item> {
  
    var url:string = "http://localhost:8050/item/getItemById?id=" + item_id;

    return this.http.get<Item>(url);
  }

  // delete Item
  public delItem(id:number): Observable<boolean> {

    var url:string = "http://localhost:8050/item/delItem?id=" + id;

    return this.http.get<boolean>(url);
  }

    // Get Search ItemList
  public getItemListByName(item_name:string): Observable<Item[]> {
    
    var url:string = "http://localhost:8050/item/getListByName?itemName=" + item_name;

    return this.http.get<Item[]>(url);
  }

  // Get CartItem List
  public getCartItemList(user_id:string):Observable<CartItem[]> {

    var url:string = "http://localhost:8050/cart/getCartItemListByBuyer?buyer=" + user_id;

    return this.http.get<CartItem[]>(url);
  }

  // Add CartItem
  public addCartItem(cartItem:CartItem): Observable<boolean> {

    var url:string = "http://localhost:8050/cart/addCartItem";

    return this.http.post<boolean>(url, cartItem);
  }
  
  // delete CartItem
  public delCartItem(id:number): Observable<boolean> {

    var url:string = "http://localhost:8050/cart/delCartItem?id=" + id;

    return this.http.get<boolean>(url);
  }

  // Get Deal(purchase history) List By Buyer
  public getDealListByBuyer(user_id:string):Observable<Deal[]> {

    var url:string = "http://localhost:8050/deal/getDealListByBuyer?buyer=" + user_id;

    return this.http.get<Deal[]>(url);

  }

  // Get Deal(purchase history) List By Seller
  public getDealListBySeller(user_id:string):Observable<Deal[]> {

    var url:string = "http://localhost:8050/deal/getDealListBySeller?seller=" + user_id;

    return this.http.get<Deal[]>(url);

  }

  // Add Deal
  public addDeal(deal:Deal): Observable<boolean> {

    var url:string = "http://localhost:8050/deal/addDeal";

    return this.http.post<boolean>(url, deal);
  }
}
