import { Component, Input, OnInit } from '@angular/core';
import { Tag } from '../shared/models/foods';
import { FoodService } from '../services/food.service';
@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {
  @Input()
  tags?:Tag[]=[];
  foodPagetags?:string[];
constructor(private fs:FoodService){}
ngOnInit():void{
  if(!this.foodPagetags)
  this.tags=this.fs.getAllTag();
}
}
