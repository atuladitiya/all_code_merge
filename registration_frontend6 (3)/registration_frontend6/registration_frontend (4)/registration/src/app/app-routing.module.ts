import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateComponent } from './update/update.component';


import { UserCardComponent } from './user-card/user-card.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  {
  path: 'app-update/:email',
component: UpdateComponent 
  },
  {
  path: 'app-update/:email',
component: UpdateComponent 
  },
  {
    path:'',
    component:UsersComponent
    },
  {
    path:'app-user-card/:email',
    component:UserCardComponent  
  },
  
  
  

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
