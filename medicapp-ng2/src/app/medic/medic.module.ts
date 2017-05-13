import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';

import { WorkService } from './work.service'
import { WorkComponent } from './work.component'
import { ConsultationService } from "../consultation/consultation.service"
import {MaterializeDirective} from "angular2-materialize";
import { PatientService } from "../patients/patient.service"
import { MedicConsult } from "../medic/medic-consult-view.component"
import { ConsultCompletePage } from "./consult-page"

@NgModule({
    imports:[
            CommonModule,
            FormsModule,
            ReactiveFormsModule,
            RouterModule,
            HttpModule,
    ],
    declarations: [
            WorkComponent,
            MedicConsult,
            ConsultCompletePage
    ],
    exports: [
            WorkComponent,
            MedicConsult,
            ConsultCompletePage
    ],
    providers: [
            WorkService , ConsultationService , PatientService
    ]         
})

export class MedicModule{}