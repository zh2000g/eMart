import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignupComponent } from './signup/signup/signup.component';
import { LoginComponent } from './login/login.component';
import { SearchListComponent } from './search-list/search-list.component';
import { HistoryComponent } from './history/history.component';
import { CategoryComponent } from './category/category/category.component';
import { CartComponent } from './cart/cart.component';
import { ItemDetailComponent } from './item-detail/item-detail.component';

import { SellerMainComponent } from './seller/seller-main/seller-main.component';
import { SellerItemListComponent } from './seller/seller-item-list/seller-item-list.component';
import { SellerSoldReportComponent } from './seller/seller-sold-report/seller-sold-report.component';
import { SellerItemAddComponent } from './seller/seller-item-add/seller-item-add.component';
import { SellerProfileEditComponent } from './seller/seller-profile-edit/seller-profile-edit.component';
import { PaymentComponent } from './payment/payment.component';


const routes: Routes = [
  {
    path: 'signup',
      component: SignupComponent
  },
  {
    path: 'login',
      component: LoginComponent
  },
  {
    path: 'searchList',
      component: SearchListComponent
  },
  {
    path: 'history',
      component: HistoryComponent
  },
  {
    path: 'category',
      component: CategoryComponent
  },
  {
    path: 'cart',
      component: CartComponent
  },
  {
    path: 'itemDetail',
      component: ItemDetailComponent
  },
  {
    path: 'seller',
      component: SellerMainComponent,
      children:[
        {
          path: 'sellerItemList', 
          component: SellerItemListComponent
        },
        {
          path: 'sellerSoldReport', 
          component: SellerSoldReportComponent
        },
        {
          path: 'sellerItemAdd', 
          component: SellerItemAddComponent
        },
        {
          path: 'sellerProfileEdit', 
          component: SellerProfileEditComponent
        }
      ]
  },
  {
    path: 'payment',
      component: PaymentComponent
  },
  {
    path: '**',
      component: LoginComponent
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
