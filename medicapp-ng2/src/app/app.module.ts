import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterializeModule } from 'angular2-materialize';
import { LoadingAnimateModule, LoadingAnimateService } from 'ng2-loading-animate';


import { AppComponent } from './app.component';
import { NavbarComponent } from "./navbar/navbar.component"
import { PatientModule } from "./patients/patient.module"
import { StaffModule } from "./staff-accounts/staff.module"
import { routing } from './app.routing';
import { ConsultationModule } from "./consultation/consultation.module"
import { MedicModule } from "./medic/medic.module"

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    StaffModule,
    MedicModule,
    PatientModule,
    ConsultationModule,
    LoadingAnimateModule,
    HttpModule,
    //MaterializeModule,
    routing
  ],
  providers: [LoadingAnimateService],
  bootstrap: [AppComponent]
})
export class AppModule { }
