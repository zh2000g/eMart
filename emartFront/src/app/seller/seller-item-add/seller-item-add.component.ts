import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { Item } from '../../class/item';
import { Category } from '../../class/category';
import { CategoryService } from '../../service/category.service';
import { ItemService } from '../../service/item.service';

@Component({
  selector: 'app-seller-item-add',
  templateUrl: './seller-item-add.component.html',
  styleUrls: ['./seller-item-add.component.scss']
})
export class SellerItemAddComponent implements OnInit {

  item: Item;

  userId:string;
  category_list: Category[];
  subcategory_list: Category[];

  constructor(
      private itemService: ItemService,
      private categoryService: CategoryService, 
      private router: Router) { }

  ngOnInit(): void {
    this.userId = sessionStorage.getItem('login_user_id');

    var id = sessionStorage.getItem('item_id');

    alert(id);
    if(id != null) {
      alert("333");
      this.itemService.getItem(id).subscribe((data:Item) =>{
        alert("444");
        this.item = data;
      });
    } else {
      this.item = new Item();
    }

    this.item.seller = this.userId;

    this.categoryService.getALLCategory().subscribe((data:Category[])  => {
      this.categoryService.category_list = data;
      this.category_list = this.categoryService.getCategoryList(0);
    });
  }

  public addItem() {
      
    this.itemService.addItem(this.item).subscribe( (data:boolean)  => {
      var returnRev = data;

      // Seller Save OK
      if(returnRev){
          alert("Add Item OK.");
          this.router.navigateByUrl("/seller")
      } else {
        alert("Add Item Falure. \n Please input currect!");
      }
    });
  }

  public catChange() {
    if(this.item.categoryId == 999) {
      this.subcategory_list = [];
    } else {
      this.subcategory_list = this.categoryService.getCategoryList(this.item.categoryId);
    }
  }

}
