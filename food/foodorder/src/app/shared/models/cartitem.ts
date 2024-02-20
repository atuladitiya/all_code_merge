import { Foods } from "./foods";

export class Cartitem{
    constructor(public food: Foods) {}

  private _quantity: number = 1;

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }

  get price(): number {
    return this.food.price * this.quantity;
  }
}

   /* constructor(food:Foods){
        this.food=food;
    }
    food:Foods;
    quantity:number =1;
    
    
        
    
    
    get price():number{
        return this.food.price * this.quantity;
    }
    */

