import { Component, OnInit, Input, OnChanges, SimpleChanges} from '@angular/core';

import { Category } from '../../class/category';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-subcategory',
  templateUrl: './subcategory.component.html',
  styleUrls: ['./subcategory.component.scss']
})
export class SubcategoryComponent implements OnInit, OnChanges {

  @Input()
  parent_category_id:number;

  parent_catetory_name:string;
  
  category_list: Category[];

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void { }

  ngOnChanges(changes: SimpleChanges) : void{

    this.category_list = this.categoryService.getCategoryList(this.parent_category_id);

    this.parent_catetory_name = this.categoryService.getCategoryName(this.parent_category_id);

  }

}
