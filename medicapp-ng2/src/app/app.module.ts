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
import { LoginComponent } from './home/login.component';
import { AuthenticationService } from './home/authentication.service'
import { AuthGuard } from './home/auth.guard'
import {MaterializeDirective} from "angular2-materialize";
import { AdminAuthGuard } from "./home/admin-auth.guard"
import { MedicAuthGuard } from "./home/medic-auth.guard"
import { SecretaryAuthGuard } from "./home/secretary-auth.guard"

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent
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
    
    routing
  ],
  providers: [LoadingAnimateService , AuthenticationService , AuthGuard , AdminAuthGuard ,MedicAuthGuard , SecretaryAuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
