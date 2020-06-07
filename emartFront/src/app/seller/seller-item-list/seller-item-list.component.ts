import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Item } from '../../class/item';
import { ItemService } from '../../service/item.service';

@Component({
  selector: 'app-seller-item-list',
  templateUrl: './seller-item-list.component.html',
  styleUrls: ['./seller-item-list.component.scss']
})
export class SellerItemListComponent implements OnInit {

  COUNT_PER_PAGE:number = 5;

  user_id:string;

  item_list:Item[];
  cur_page_item_list:Item[] = [];
  page_list:number[] = [];

  constructor(private itemService: ItemService, private router: Router) { }

  ngOnInit(): void {
    this.user_id = sessionStorage.getItem("login_user_id");

    this.itemService.getStockItemList(this.user_id).subscribe((data:any)  => {
      this.item_list = data

      let page_count:number = Math.ceil(this.item_list.length / this.COUNT_PER_PAGE);

      for (let i = 0; i < page_count; i++) {
        this.page_list[i] = i + 1;
      }
      this.pageChange(1);
    });
   
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

//  public editItem(itemId:number) :any {
  public editItem(itemId:number) :any {
    sessionStorage.setItem('item_id', itemId + "");
    this.router.navigateByUrl("/seller/sellerItemAdd");

  }

  //  public editItem(itemId:number) :any {
  public addItem() :any {
    sessionStorage.setItem('item_id', "");
    this.router.navigateByUrl("/seller/sellerItemAdd");

  }

}
