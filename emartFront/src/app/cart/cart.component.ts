import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Item } from '../class/item';
import { CartItem } from '../class/cart-item';
import { ItemService } from '../service/item.service';
import { Deal } from '../class/deal';

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

  public payment() {
    var successNum:number = 0;

    this.cart_item_list.forEach(cartItem => {
      var deal:Deal = new Deal();

      deal.itemId   = cartItem.itemId;
      deal.itemName = cartItem.itemName;
      deal.categoryId   = cartItem.categoryId;
      deal.subCategoryId= cartItem.subCategoryId;
      deal.seller   = cartItem.seller;
      deal.buyer    = cartItem.buyer;
      deal.price    = cartItem.price;
      deal.purchaseNum  = cartItem.addNum;
      deal.purchaseTime = new Date();
alert("Add Deal start="+deal.itemId);  
      // Add Deal OK
      this.itemService.addDeal(deal).subscribe( (data:boolean)  => {
        var returnRev:boolean = data;
alert("Add Deal returnRev="+returnRev);
        // When add deal OK, then delete cartItem
        if(returnRev){
alert("Add Deal OK="+deal.itemId);
          this.itemService.delCartItem(cartItem.id).subscribe( (data:boolean)  => {
            var returnRev:boolean = data;
alert("delCartItem returnRev="+returnRev);   
            // delete cartItem failure
            if(returnRev){
              successNum ++;
alert("delCartItem OK="+cartItem.id);  
              if(successNum == this.cart_item_list.length) {
                // Go to success page.
                this.router.navigateByUrl("/payment")
              } 
            }
          });
        } 
      });
    });

    

  }

}
