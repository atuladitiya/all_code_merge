import { EventEmitter, Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Login, SignUp } from '../shared/models/datatype';
import { BehaviorSubject } from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  isSellerLoggedIn= new BehaviorSubject<boolean>(false);
  isLoginError= new EventEmitter<boolean>(false); 

  constructor(private http:HttpClient,private router:Router) { }
  userSignUp(data:SignUp){
  let result= this.http.post('http://localhost:3000/customer',data,{
    observe:'response'
  }).subscribe((result)=>{
    this.isSellerLoggedIn.next(true);
    localStorage.setItem('customer',JSON.stringify(result.body))
    this.router.navigate(['home']);
    
  });   
  
  
  }
  reloadCustomer(){
    if(localStorage.getItem('customer')){    
      this.isSellerLoggedIn.next(true);
      this.router.navigate(['customerhome']);
    }
  }
  userLogin(data:Login){
    console.warn(data);
    this.http.get(`http://localhost:3000/customer?email=${data.email}&password=${data.password}`,{
      observe:'response'
    }).subscribe((result:any)=>{
      console.warn(result);
      if(result && result.body && result.body.length)
      {
        console.warn("User Logged In");
        localStorage.setItem('customer',JSON.stringify(result.body));
    this.router.navigate(['customerhome']);
      }
      else{
        console.warn("Login Failed");
        this.isLoginError.emit(true);
      }
    })
  }

}
