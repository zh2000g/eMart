import { Injectable } from '@angular/core';
import { Item } from '../class/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() { }

  public getItemList():Item[]{

    let item_list:Item[] = [];

    for (let index = 0; index < 31; index++) {
      let item:Item = {
        item_id:"index",
        item_name:"Thinkpad" + " - " + index,
        category:"Computer",
        sub_category:"Note PC",
        seller:"Seller1",
        buyer:"Buyer1",
        price:4999,
        current_num:3,
        remain_num:100,
        purchase_time:"2020/4/29 10:20:30",
        image_url_1:"/assets/images/thinkpad.jpg",
        image_url_2:"image2",
        image_url_3:"image3",
        image_url_4:"image4"
      };

      item_list.push(item);
    }

    return item_list;
  }

  public getCartItemList(user_id:string):Item[]{

    let item_list:Item[] = [];

    for (let index = 0; index < 8; index++) {
      let item:Item = {
        item_id:"index",
        item_name:"Thinkpad" + " - " + index,
        category:"Computer",
        sub_category:"Note PC",
        seller:"Seller1",
        buyer:"Buyer1",
        price:4999,
        current_num:3,
        remain_num:100,
        purchase_time:"2020/4/29 10:20:30",
        image_url_1:"/assets/images/thinkpad.jpg",
        image_url_2:"image2",
        image_url_3:"image3",
        image_url_4:"image4"
      };

      item_list.push(item);
    }

    return item_list;
  }

  public getStockItemList(user_id:string):Item[]{

    let item_list:Item[] = [];

    for (let index = 0; index < 8; index++) {
      let item:Item = {
        item_id:"index",
        item_name:"Thinkpad" + " - " + index,
        category:"Computer",
        sub_category:"Note PC",
        seller:"Seller1",
        buyer:"Buyer1",
        price:4999,
        current_num:3,
        remain_num:100,
        purchase_time:"2020/4/29 10:20:30",
        image_url_1:"/assets/images/thinkpad.jpg",
        image_url_2:"image2",
        image_url_3:"image3",
        image_url_4:"image4"
      };

      item_list.push(item);
    }

    return item_list;
  }

  public getSoldItemList(user_id:string):Item[]{

    let item_list:Item[] = [];

    for (let index = 0; index < 16; index++) {
      let item:Item = {
        item_id:"index",
        item_name:"Thinkpad" + " - " + index,
        category:"Computer",
        sub_category:"Note PC",
        seller:"Seller1",
        buyer:"Buyer1",
        price:4999,
        current_num:3,
        remain_num:100,
        purchase_time:"2020/4/29 10:20:30",
        image_url_1:"/assets/images/thinkpad.jpg",
        image_url_2:"image2",
        image_url_3:"image3",
        image_url_4:"image4"
      };

      item_list.push(item);
    }

    return item_list;
  }
}
