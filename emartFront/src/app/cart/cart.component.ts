import { Component, OnInit } from '@angular/core';

import { Item } from '../class/item';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  COUNT_PER_PAGE:number = 5;

  login_user_id:string;

  item_list:Item[];
  cur_page_item_list:Item[] = [];
  page_list:number[] = [];
  
  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    this.login_user_id = sessionStorage.getItem("login_user_id");

    this.item_list = this.itemService.getCartItemList(this.login_user_id);

    let page_count:number = Math.ceil(this.item_list.length / this.COUNT_PER_PAGE);

    for (let i = 0; i < page_count; i++) {
      this.page_list[i] = i + 1;
    }

    this.pageChange(1);
  }

  public pageChange(cur_page:number) :any {

    let min = (cur_page - 1) * this.COUNT_PER_PAGE + 1;
    let max = cur_page * this.COUNT_PER_PAGE

    if(max > this.item_list.length) {
      max = this.item_list.length;
    }

    this.cur_page_item_list = [];
    for (let j = min - 1; j < max; j++) {
      this.cur_page_item_list.push(this.item_list[j]);
    }

    return false;
  } 

}
