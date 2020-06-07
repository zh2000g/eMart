import { Component, OnInit } from '@angular/core';

import { Deal } from '../../class/deal';
import { ItemService } from '../../service/item.service';

@Component({
  selector: 'app-seller-sold-report',
  templateUrl: './seller-sold-report.component.html',
  styleUrls: ['./seller-sold-report.component.scss']
})
export class SellerSoldReportComponent implements OnInit {

  COUNT_PER_PAGE:number = 5;

  login_user_id:string;

  deal_list:Deal[];
  cur_page_deal_list:Deal[] = [];
  page_list:number[] = [];


  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    
    this.login_user_id = sessionStorage.getItem("login_user_id");

    this.itemService.getDealListBySeller(this.login_user_id).subscribe((data:Deal[])  => {
      this.deal_list = data;

      let page_count:number = Math.ceil(this.deal_list.length / this.COUNT_PER_PAGE);

      for (let i = 0; i < page_count; i++) {
        this.page_list[i] = i + 1;
      }

      this.pageChange(1);
    });
    

  }

  public pageChange(cur_page:number) :any {

    let min = (cur_page - 1) * this.COUNT_PER_PAGE + 1;
    let max = cur_page * this.COUNT_PER_PAGE

    if(max > this.deal_list.length) {
      max = this.deal_list.length;
    }

    this.cur_page_deal_list = [];
    for (let j = min - 1; j < max; j++) {
      this.cur_page_deal_list.push(this.deal_list[j]);
    }

    return false;
  } 

}
