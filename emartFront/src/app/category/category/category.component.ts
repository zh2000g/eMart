import { Component, OnInit } from '@angular/core';

import { Category } from '../../class/category';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  category_id:any = "";
  category_list: Category[];

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.category_list = this.categoryService.getCatetoryList("");
  }

  public categoryClick(category_id:any) {
    this.category_id = category_id;
    return false;
  }

}
