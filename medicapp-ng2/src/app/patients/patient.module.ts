import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';


import { PatientService } from  './patient.service'
import { PatientComponent } from './patient.component'
import { PatientFormComponent } from './patient-form.component';

@NgModule({
    imports:[
            CommonModule,
            FormsModule,
            ReactiveFormsModule,
            RouterModule,
            HttpModule,
    ],
    declarations: [
            PatientComponent,
            PatientFormComponent
    ],
    exports: [
            PatientComponent
    ],
    providers: [
            PatientService
    ]         
})

export class PatientModule{}