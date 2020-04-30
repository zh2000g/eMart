import { Injectable } from '@angular/core';
import { Category } from '../class/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private category_list:Category[];
  
  constructor() {
    this.useTestData();
   }

  public getCatetoryList(p_category_id:string):Category[] {
    let cList:Category[] = [];

    for (let i = 0; i < this.category_list.length; i++) {
      let category = this.category_list[i];

      if(category.parent_category_id == p_category_id) {
        cList.push(category);
      }      
    }
    return cList;
  }

  public getCatetoryName(category_id:string):string {
    let category_name:string;

    for (let i = 0; i < this.category_list.length; i++) {
      let category = this.category_list[i];

      if(category.category_id == category_id) {
        category_name = category.category_name
      }      
    }
    return category_name;
  }

  
  // use testdata
  useTestData(){    
    this.category_list = [
      {
        category_id:"1",
        category_name:"Computer",
        parent_category_id:""
      },
      {
        category_id:"2",
        category_name:"Books",
        parent_category_id:""
      },
      {
        category_id:"3",
        category_name:"Cloths",
        parent_category_id:""
      },
      {
        category_id:"4",
        category_name:"Note PC",
        parent_category_id:"1"
      },
      {
        category_id:"5",
        category_name:"Tablelet",
        parent_category_id:"1"
      },
      {
        category_id:"6",
        category_name:"Pocket PC",
        parent_category_id:"1"
      },
      {
        category_id:"7",
        category_name:"Noval",
        parent_category_id:"2"
      }
    ];
  }
}


