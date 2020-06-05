import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Item } from '../class/item';
import { CartItem } from '../class/cart-item';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  COUNT_PER_PAGE:number = 5;

  login_user_id:string;

  cart_item_list:CartItem[];
  cur_page_cart_item_list:CartItem[] = [];

  page_list:number[] = [];
  
  constructor(private itemService: ItemService, private router: Router) { }

  ngOnInit(): void {
    this.login_user_id = sessionStorage.getItem("login_user_id");

    this.itemService.getCartItemList(this.login_user_id).subscribe((data:CartItem[])  => {
      this.cart_item_list = data;

      let page_count:number = Math.ceil(this.cart_item_list.length / this.COUNT_PER_PAGE);

      for (let i = 0; i < page_count; i++) {
        this.page_list[i] = i + 1;
      }
  
      this.pageChange(1);
    });
   
  }

  public pageChange(cur_page:number) :any {

    let min = (cur_page - 1) * this.COUNT_PER_PAGE + 1;
    let max = cur_page * this.COUNT_PER_PAGE

    if(max > this.cart_item_list.length) {
      max = this.cart_item_list.length;
    }

    this.cur_page_cart_item_list = [];
    for (let j = min - 1; j < max; j++) {
      this.cur_page_cart_item_list.push(this.cart_item_list[j]);
    }

    return false;
  } 

  public buyItem(itemId:number) :any {
    sessionStorage.setItem('item_id', itemId + "");
    this.router.navigateByUrl("/itemDetail");

    return false;
  }

    public delCartItem(id:number) :any{

    this.itemService.delCartItem(id).subscribe( (data:boolean)  => {
      var returnRev = data;

      // Seller Save OK
      if(returnRev){
          alert("delete CartItem OK.");
          this.router.navigateByUrl("/cart")
      } else {
        alert("delete CartItem Falure. \n Please try again!");
      }
    });

  }

}
