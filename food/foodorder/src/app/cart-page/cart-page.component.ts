import { Component, OnInit } from '@angular/core';

import { Cart } from '../shared/models/cart';
import { Foods } from '../shared/models/foods';
import {  Cartitem } from '../shared/models/cartitem';
import { CartService } from '../services/cart.service';
import { FoodService } from '../services/food.service';


@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {
  cart!:Cart;
  constructor(private cartService:CartService,private foodservice:FoodService){
   
    this.setCart();
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  setCart(){
    this.cart=this.cartService.getCart();
  }

  
  removeFromCart(cartItme:Cartitem){
    this.cartService.removeFromCart(cartItme.food.id);
    this.setCart();
  }
  
  changeQuantity(cartItem:Cartitem,quantityInString:string){
    const quantity=parseInt(quantityInString);
    this.cartService.changeQuantity(cartItem.food.id,quantity);
    this.setCart();
  } 

}
/*setCart(){
  this.cart=this.cartService.getCart();


}

}






function ngOnInit() {
  throw new Error('Function not implemented.');
}
function setCart() {
  throw new Error('Function not implemented.');
}

function removeFromCart(cartItme: any, cartitem: any) {
  throw new Error('Function not implemented.');
}

function changeQuantity(cartItem: any, Cartitem: typeof Cartitem, quantityInString: any, string: any) {
  throw new Error('Function not implemented.');
}

*/