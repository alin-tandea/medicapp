import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule }   from '@angular/router';

import { PatientComponent } from "./patient/patient.component"

const appRoutes: Routes = [
    { path: 'patients', pathMatch: 'full', component: PatientComponent },
    { path: '**', redirectTo: 'patients' },
   
  
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);