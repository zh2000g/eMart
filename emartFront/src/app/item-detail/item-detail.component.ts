import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Item } from '../class/item';
import { Category } from '../class/category';
import { CartItem } from '../class/cart-item';
import { CategoryService } from '../service/category.service';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.scss']
})
export class ItemDetailComponent implements OnInit {

  item: Item;
  addNum:number;

  userId:string;
  category_list: Category[];
  categoryName: string;
  subcategoryName: string;

  constructor(private itemService: ItemService,private categoryService: CategoryService,private router: Router) { }

  ngOnInit(): void {
    this.userId = sessionStorage.getItem('login_user_id');

    var id = sessionStorage.getItem('item_id');
    alert(id);

    if(id != null) {
      this.itemService.getItem(id).subscribe((data:Item) =>{
        this.item = data;

        this.categoryService.getALLCategory().subscribe((data:Category[])  => {
          this.categoryService.category_list = data;

          this.categoryName = this.categoryService.getCategoryName(this.item.categoryId);
          this.subcategoryName = this.categoryService.getCategoryName(this.item.subCategoryId);
        });

      });
    }
  }

  public addToCart() :any{
    var cartItem:CartItem = new CartItem();
    
    cartItem.itemId = this.item.id;
    cartItem.itemName = this.item.itemName;
    cartItem.categoryId =  this.item.categoryId;
    cartItem.subCategoryId = this.item.subCategoryId;
    cartItem.seller = this.item.seller;
    cartItem.buyer = this.userId;
    cartItem.price = this.item.price;
    cartItem.addNum =this.addNum;
    cartItem.addTime = new Date();

    this.itemService.addCartItem(cartItem).subscribe( (data:boolean)  => {
      var returnRev = data;

      // Seller Save OK
      if(returnRev){
          alert("Add Item OK.");
          this.router.navigateByUrl("/selsearchList")
      } else {
        alert("Add CartItem Falure. \n Please try again!");
      }
    });

  }

}
