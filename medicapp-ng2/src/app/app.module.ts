import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
//import { MaterializeModule } from 'angular2-materialize';

import { AppComponent } from './app.component';
import { NavbarComponent } from "./navbar/navbar.component"
import { PatientModule } from "./patients/patient.module"
import { routing } from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    PatientModule,
    HttpModule,
    //MaterializeModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
