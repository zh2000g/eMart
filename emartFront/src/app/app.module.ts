import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup/signup.component';
import { SignupBuyerComponent } from './signup/signup-buyer/signup-buyer.component';
import { SignupSellerComponent } from './signup/signup-seller/signup-seller.component';
import { SearchListComponent } from './search-list/search-list.component';
import { HistoryComponent } from './history/history.component';
import { CategoryComponent } from './category/category/category.component';
import { SubcategoryComponent } from './category/subcategory/subcategory.component';
import { CartComponent } from './cart/cart.component';
import { ItemDetailComponent } from './item-detail/item-detail.component';
import { SellerMainComponent } from './seller/seller-main/seller-main.component';
import { SellerItemListComponent } from './seller/seller-item-list/seller-item-list.component';
import { SellerSoldReportComponent } from './seller/seller-sold-report/seller-sold-report.component';
import { SellerItemAddComponent } from './seller/seller-item-add/seller-item-add.component';
import { SellerProfileEditComponent } from './seller/seller-profile-edit/seller-profile-edit.component';
import { PaymentComponent } from './payment/payment.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    SignupBuyerComponent,
    SignupSellerComponent,
    SearchListComponent,
    HistoryComponent,
    CategoryComponent,
    SubcategoryComponent,
    CartComponent,
    ItemDetailComponent,
    SellerMainComponent,
    SellerItemListComponent,
    SellerSoldReportComponent,
    SellerItemAddComponent,
    SellerProfileEditComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
