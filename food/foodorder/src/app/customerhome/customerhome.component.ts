import { Component,OnInit } from '@angular/core';
import { FoodService } from '../services/food.service';
import { Foods } from '../shared/models/foods';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customerhome',
  templateUrl: './customerhome.component.html',
  styleUrls: ['./customerhome.component.css']
})
export class CustomerhomeComponent implements OnInit {
 
  
    Foodlist:Foods[]= []
    constructor(private food: FoodService,private route:ActivatedRoute) {}
    ngOnInit():void {
      this.route.params.subscribe(params =>{
        if(params['searchItem'])
         this.Foodlist=this.food.getAll().filter(item => item.name.toLowerCase().includes(params['searchItem'].toLowerCase()))
        else if(params['tag'])
        this.Foodlist=this.food.getAllFoodByTag(params['tag'])
        else
          this.Foodlist=this.food.getAll();
        
      })
     
  
  
  
  
    }
    getStarArray(stars: number): any[] {
      return Array(Math.floor(stars)).fill(0);
    }
  
  }
  

