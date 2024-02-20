import { Injectable } from '@angular/core';
import { Foods, Tag } from '../shared/models/foods';

@Injectable({
  providedIn: 'root'
})
export class FoodService  {

  constructor() { }
  getFoodById(id:number):Foods{
    return this.getAll().find(food=>food.id==id)!
  }
  getAllFoodByTag(tag: string):Foods[]{
    return tag == 'All'? this.getAll() : this.getAll().filter(food=> food.tags?.includes(tag))

  }
  getAllTag():Tag[]{
   return [
      {
        name:'All',count:8
      },
      {
        name:'Vegetarian',count:8
      },
      {
        name:'Breakfast',count:2
      },
      {
        name:'Lunch',count:4
      },
      {
        name:'Supper',count:1
      },
      {
        name:'Dinner',count:1
      },
      
      
      
      


    ]

  }
  getAll(): Foods[]{
    return [
{
  id:1,
  name:'Paneer Pizza',
  cookTime:'10:20',
  price: 269,
  favourite:false,
  origins:['Italy','India'],
  stars: 4.5,
  imageUrl:'assets/food1.jpeg',
  tags:['Vegetarian','Lunch']
},
{
  id:2,
  name:'Paneer Chilli',
  cookTime:'10:59',
  price: 269,
  favourite:true,
  origins:['India','China'],
  stars: 4,
  imageUrl:'assets/food2.jpeg',
  tags:['Vegetarian','Breakfast']
},
{
  id:3,
  name:'Chicken Chilli',
  cookTime:'9:40',
  price: 200,
  favourite:false,
  origins:['China','India'],
  stars: 4.9,
  imageUrl:'assets/food3.jpeg',
  tags:['Vegetarian','Lunch']
},
{
  id:4,
  name:'Chowmein',
  cookTime:'12:08',
  price: 70,
  favourite:true,
  origins:['China'],
  stars: 3.5,
  imageUrl:'assets/food4.jpeg',
  tags:['Vegetarian','Supper']
},
{
  id:5,
  name:'Momos',
  cookTime:'4:40',
  price: 120,
  favourite:false,
  origins:['China'],
  stars: 4.5,
  imageUrl:'assets/food5.jpeg',
  tags:['Vegetarian','Breakfast']
},
{
  id:6,
  name:'Thaali',
  cookTime:'12:20',
  price: 300,
  favourite:true,
  origins:['India'],
  stars: 5.0,
  imageUrl:'assets/food6.jpeg',
  tags:['Vegetarian','Dinner']
},
{
  id:7,
  name:'Kadahi Paneer',
  cookTime:'11:39',
  price: 350,
  favourite:false,
  origins:['India'],
  stars: 4.2,
  imageUrl:'assets/food7.jpg',
  tags:['Vegetarian','Lunch']
},
{
  id:8,
  name:'Veg Fried Rice',
  cookTime:'10:49',
  price: 140,
  favourite:true,
  origins:['India','Italy'],
  stars: 4,
  imageUrl:'assets/food8.jpeg',
  tags:['Vegetarian','Lunch'],
}];
  }
}

