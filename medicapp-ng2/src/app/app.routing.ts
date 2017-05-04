import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule }   from '@angular/router';

import { PatientComponent } from "./patients/patient.component"
import { PatientFormComponent } from './patients/patient-form.component';

const appRoutes: Routes = [
    { path: 'patients', component: PatientComponent },
    { path: 'patients/new' , component : PatientFormComponent},
    { path: 'patients/:idPatient' , component : PatientFormComponent },
   
  
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);