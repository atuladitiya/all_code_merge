import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import {Router} from '@angular/router';
import { Login, SignUp } from '../shared/models/datatype';

@Component({
  selector: 'app-customersignup',
  templateUrl: './customersignup.component.html',
  styleUrls: ['./customersignup.component.css']
})
export class CustomersignupComponent implements OnInit {
 
  constructor(private customer:CustomerService,private router:Router){}
  showLogin=false;
  authError:string='';
  ngOnInit():void{
    
      this.customer.reloadCustomer();
    }
  

signup(data:SignUp):void{
  console.warn(data);
  
  this.customer.userSignUp(data);
}
Login(data:Login):void{
  this.authError="";
  
  this.customer.userLogin(data);
  this.customer.isLoginError.subscribe((isError)=>{
    if(isError){
      this.authError="Email or password is not correct";
    }
  })
  
  
}

openLogin(){
this.showLogin=true;
}
openSignUp(){
  this.showLogin=false;
}
}

