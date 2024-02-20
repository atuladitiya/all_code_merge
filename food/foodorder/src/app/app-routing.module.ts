import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FoodpageComponent } from './foodpage/foodpage.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { SignupComponent } from './signup/signup.component';
import { AuthGuard } from './auth.guard';
import { CustomerhomeComponent } from './customerhome/customerhome.component';
import { CustomersignupComponent } from './customersignup/customersignup.component';

const routes: Routes = [
  {
    path:'',
    component: CustomersignupComponent
  },
  {
    path:'customerhome',
    component:CustomerhomeComponent,
    canActivate:[AuthGuard]
  },
  {
  path:'search/:searchItem',
  component:HomeComponent
  },
  {
    path:'tag/:tag',
    component:HomeComponent
  },
  {
    path:'food/:id',
    component:FoodpageComponent
  },{
  path:'cart-page',
  component:CartPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
