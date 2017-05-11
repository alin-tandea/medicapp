import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';
import {MaterializeDirective} from "angular2-materialize";

import { ConsultationService } from "./consultation.service"
import { ConsultationComponent } from "./consultation.component"
import { ConsultationFormComponent } from "./consultation-form.component"
import { MedicComponent } from '../medic/medic.component'
import { MedicOtherComponent } from "../medic/medic-other.component"

@NgModule({
    imports:[
            CommonModule,
            FormsModule,
            ReactiveFormsModule,
            RouterModule,
            HttpModule,
    ],
    declarations: [
            MaterializeDirective,
            ConsultationComponent,
            ConsultationFormComponent,
            MedicComponent,
            MedicOtherComponent
    ],
    exports: [
            ConsultationComponent,
            ConsultationFormComponent,
            MedicComponent,
            MedicOtherComponent
    ],
    providers: [
            ConsultationService
    ]         
})

export class ConsultationModule{}