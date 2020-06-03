import { Component, OnInit } from '@angular/core';

import { Category } from '../../class/category';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  category_id:number = 0;
  category_list: Category[];

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.categoryService.getALLCategory().subscribe((data:Category[])  => {
      this.categoryService.category_list = data;
      this.category_list = this.categoryService.getCategoryList(0);
    });
  }

  public categoryClick(category_id:number) {
    this.category_id = category_id;
    return false;
  }

}
