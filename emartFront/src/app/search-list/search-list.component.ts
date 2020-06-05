import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Item } from '../class/item';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-search-list',
  templateUrl: './search-list.component.html',
  styleUrls: ['./search-list.component.scss']
})
export class SearchListComponent implements OnInit {

  COUNT_PER_PAGE:number = 5;

  login_user_id:string;
  search_name:string;

  item_list:Item[];
  cur_page_item_list:Item[] = [];
  page_list:number[] = [];


  constructor(private itemService: ItemService, private router: Router) { }
  
  ngOnInit(): void {
    this.login_user_id = sessionStorage.getItem("login_user_id");

    this.itemService.getItemListByName("").subscribe((data:Item[])  => {
      this.item_list = data;

      let page_count:number = Math.ceil(this.item_list.length / this.COUNT_PER_PAGE);

      for (let i = 0; i < page_count; i++) {
        this.page_list[i] = i + 1;
      }

      this.pageChange(1);
    });
  }

  public search():void {

    this.itemService.getItemListByName(this.search_name).subscribe((data:Item[])  => {
      this.item_list = data;

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

  public buyItem(itemId:number) :any {
    sessionStorage.setItem('item_id', itemId + "");
    this.router.navigateByUrl("/itemDetail");

    return false;
  }


}
