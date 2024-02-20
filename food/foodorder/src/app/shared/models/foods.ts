export class Foods{
    id!:number;
    price!:number;
    name!:string;
    favourite:boolean=false;
    stars!:number;
    tags?:string[];
    imageUrl!:string;
    cookTime!:string;
    origins!:string[];



}
export class Tag{
    name!:String;
    count!:number;
}