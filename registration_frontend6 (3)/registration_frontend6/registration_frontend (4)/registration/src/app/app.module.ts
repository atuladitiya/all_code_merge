import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { UsersComponent } from './users/users.component';
import { RegistrationserviceService } from './registrationservice.service';
import { HttpClientModule } from '@angular/common/http';
import { UpdateComponent } from './update/update.component';
import { RouterModule } from '@angular/router';
import { UserCardComponent } from './user-card/user-card.component';

@NgModule({
  declarations: [
    AppComponent,
    
  
    UsersComponent,
            UpdateComponent,
            UserCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    
    
  ],
  providers: [RegistrationserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
