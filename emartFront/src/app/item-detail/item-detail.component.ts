import { Component, OnInit } from '@angular/core';

import { Item } from '../class/item';
import { Category } from '../class/category';
import { CategoryService } from '../service/category.service';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.scss']
})
export class ItemDetailComponent implements OnInit {

  item: Item;

  userId:string;
  category_list: Category[];
  categoryName: string;
  subcategoryName: string;

  constructor(private itemService: ItemService,private categoryService: CategoryService) { }

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

}
