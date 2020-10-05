import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { DecorComponent } from './decor/decor.component';
import { FurnitureComponent } from './furniture/furniture.component';
import { HomeComponent } from './home/home.component';
import { LaptopComponent } from './laptop/laptop.component';
import { LoginComponent } from './login/login.component';
import { MenComponent } from './men/men.component';
import { MobileComponent } from './mobile/mobile.component';
import { WomenComponent } from './women/women.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home/:userName', component: HomeComponent},
  {path: 'mobile/:userName', component: MobileComponent},
  {path: 'laptop/:userName', component: LaptopComponent},
  {path: 'men/:userName', component: MenComponent},
  {path: 'women/:userName', component: WomenComponent},
  {path: 'furniture/:userName', component: FurnitureComponent},
  {path: 'decor/:userName', component: DecorComponent},
  {path: 'cart/:userName', component: CartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
