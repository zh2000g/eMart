import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { Category } from '../class/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  category_list:Category[];
  
  constructor(private http: HttpClient) {
  }
   
   
  public getCategoryList(p_category_id:number):Category[] {

    let cList:Category[] = [];

    for (let i = 0; i < this.category_list.length; i++) {
      let category = this.category_list[i];

      if(category.parentCategoryId == p_category_id) {
        cList.push(category);
      }      
    }
    return cList;
  }

  public getCategoryName(category_id:number):string {
    let category_name:string;

    for (let i = 0; i < this.category_list.length; i++) {
      let category = this.category_list[i];

      if(category.id == category_id) {
        category_name = category.categoryName
      }      
    }
    return category_name;
  }

  
  public getALLCategory(): Observable<Category[]> {
    var url = "http://localhost:8050/categ/getList";

    return this.http.get<Category[]>(url);
  }

}


