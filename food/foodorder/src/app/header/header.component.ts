import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  menuType:String='default';
constructor(private router:Router){}

ngOnInit():void{
  this.router.events.subscribe((val:any)=>{
    if(val.url){
      console.warn(val.url)
      if(localStorage.getItem('customer') && val.url.includes('customer')){
        console.warn("In Customer area");
        this.menuType="Seller";
      }
      else{
        console.warn("Outside Customer Area")
        this.menuType="default";
      }
    }
  })
 
}
Logout(){
  localStorage.removeItem('customer');
  this.router.navigate(['/'])
}
}
