import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { AddCompanyComponent } from './admin/add-company/add-company.component';
import { ListCompanyComponent } from './admin/list-company/list-company.component';
import { AdminNavbarComponent } from './admin/admin-navbar/admin-navbar.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { AdminSignoutComponent } from './admin/admin-signout/admin-signout.component';
import { EditCompanyComponent } from './admin/edit-company/edit-company.component';
import { AddExchangeComponent } from './admin/add-exchange/add-exchange.component';
import { ListIpoComponent } from './admin/list-ipo/list-ipo.component';
import { UpdateExchangeComponent } from './admin/update-exchange/update-exchange.component';
import { AddIposComponent } from './admin/add-ipos/add-ipos.component';
import { UpdateIposComponent } from './admin/update-ipos/update-ipos.component';
import { UserListCompanyComponent } from './user/user-list-company/user-list-company.component';
import { UserStockListComponent } from './user/user-stock-list/user-stock-list.component';
import { UserIPOListComponent } from './user/user-ipolist/user-ipolist.component';
import { UserNavbarComponent } from './user/user-navbar/user-navbar.component';
import { UserSignoutComponent } from './user/user-signout/user-signout.component';
import { ImportFileComponent } from './admin/import-file/import-file.component';
import { CompanyChartComponent } from './admin/company-chart/company-chart.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { FlashMessagesModule } from 'angular2-flash-messages';
import { StockPriceComponent } from './user/stock-price/stock-price.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AdminLoginComponent,
    UserLoginComponent,
    AddCompanyComponent,
    ListCompanyComponent,
    AdminNavbarComponent,
    ManageExchangeComponent,
    AdminSignoutComponent,
    EditCompanyComponent,
    AddExchangeComponent,
    ListIpoComponent,
    UpdateExchangeComponent,
    AddIposComponent,
    UpdateIposComponent,
    UserListCompanyComponent,
    UserStockListComponent,
    UserIPOListComponent,
    UserNavbarComponent,
    UserSignoutComponent,
    ImportFileComponent,
    CompanyChartComponent,
    SignUpComponent,
    StockPriceComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FlashMessagesModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
