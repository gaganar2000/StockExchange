import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCompanyComponent } from './admin/add-company/add-company.component';
import { AddExchangeComponent } from './admin/add-exchange/add-exchange.component';
import { AddIposComponent } from './admin/add-ipos/add-ipos.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { CompanyChartComponent } from './admin/company-chart/company-chart.component';
import { EditCompanyComponent } from './admin/edit-company/edit-company.component';
import { ImportFileComponent } from './admin/import-file/import-file.component';
import { ListCompanyComponent } from './admin/list-company/list-company.component';
import { ListIpoComponent } from './admin/list-ipo/list-ipo.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { UpdateExchangeComponent } from './admin/update-exchange/update-exchange.component';
import { UpdateIposComponent } from './admin/update-ipos/update-ipos.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { UserIPOListComponent } from './user/user-ipolist/user-ipolist.component';
import { UserListCompanyComponent } from './user/user-list-company/user-list-company.component';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { UserStockListComponent } from './user/user-stock-list/user-stock-list.component';
import { StockPriceComponent } from './user/stock-price/stock-price.component';
const routes: Routes = [

  { path:'',component:NavbarComponent },
  { path: 'admin', component:AdminLoginComponent },
  { path: 'admin/import-file', component: ImportFileComponent},
  { path: 'admin/add-company', component: AddCompanyComponent },
  { path: 'admin/list-company',component:ListCompanyComponent },
  { path: 'admin/manage-exchange',component:ManageExchangeComponent },
  { path:'admin/edit-company/:id', component:EditCompanyComponent},
  { path:'admin/update-exchange/:id' , component : UpdateExchangeComponent},
  { path:'admin/add-exchange', component: AddExchangeComponent },
  { path: 'admin/update-ipos/:id',component:UpdateIposComponent },
  { path: 'admin/list-ipo', component: ListIpoComponent },
  { path: 'admin/add-ipos', component: AddIposComponent },
  { path: 'user', component: UserLoginComponent},
  { path: 'user/list-company', component: UserListCompanyComponent},
  { path: 'user/manage-exchange', component: UserStockListComponent},
  { path: 'user/list-ipo', component:UserIPOListComponent},
  { path: 'admin/company-chart', component : CompanyChartComponent },
  { path: 'signup', component: SignUpComponent},
  { path: 'user/stock-price', component : StockPriceComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }