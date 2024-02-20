import { Cartitem } from "./cartitem";

export class Cart{
    items:Cartitem[]=[];
    get totalPrice():number{
        let totalPrice=0;
        this.items.forEach(items => {
            totalPrice+=items.price;

            
        });
        return  totalPrice;
    }

}