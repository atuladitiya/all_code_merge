import { Component, OnInit } from '@angular/core';
import { Foods } from '../shared/models/foods';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from '../services/food.service'
import { CartService } from '../services/cart.service';


@Component({
  selector: 'app-foodpage',
  templateUrl: './foodpage.component.html',
  styleUrls: ['./foodpage.component.css']
})
export class FoodpageComponent implements OnInit {
  food!:Foods;
constructor(private activatedRoute:ActivatedRoute,private foodservice:FoodService,private cartService:CartService,private router:Router){
  activatedRoute.params.subscribe((params)=>{
    if(params['id'])
    this.food=foodservice.getFoodById(params['id'])
  })
}
getStarArray(stars: number): any[] {
  return Array(Math.floor(stars)).fill(0);
}
ngOnInit():void{
  
}
addToCart(){
  this.cartService.addToCart(this.food);
  this.router.navigateByUrl('/cart-page');
}
}
