import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { Item } from '../class/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient) { }

  public getItemList():Item[]{

    let item_list:Item[] = [];


    return item_list;
  }

  public getCartItemList(user_id:string):Item[]{

    let item_list:Item[] = [];

    return item_list;
  }

    // Get OneItem
    public getItem(item_id:string): Observable<Item> {
    
      var url:string = "http://localhost:8050/item/getItemById?id=" + item_id;
  
      return this.http.get<Item>(url);
    }

  // Get Stock ItemList
  public getStockItemList(user_id:string): Observable<Item[]> {
    
    var url:string = "http://localhost:8050/item/getListBySeller?sellerId=" + user_id;

    return this.http.get<Item[]>(url);
  }

  // Get Search ItemList
  public getItemListByName(item_name:string): Observable<Item[]> {
    
    var url:string = "http://localhost:8050/item/getListByName?itemName=" + item_name;

    return this.http.get<Item[]>(url);
  }

    // Add Item
    public addItem(item:Item): Observable<boolean> {
      var url:string = "http://localhost:8050/item/addItem";
  
       return this.http.post<boolean>(url, item);
    }

  public getSoldItemList(user_id:string):Item[]{

    let item_list:Item[] = [];

    return item_list;
  }
}
