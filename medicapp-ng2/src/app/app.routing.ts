import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule }   from '@angular/router';

import { PatientComponent } from "./patients/patient.component"
import { PatientFormComponent } from './patients/patient-form.component';
import { ConsultationFormComponent } from './consultation/consultation-form.component'
import { StaffComponent } from "./staff-accounts/staff.component"
const appRoutes: Routes = [
    { path: 'patients', component: PatientComponent },
    { path: 'patients/new' , component : PatientFormComponent},
    { path: 'patients/:idPatient' , component : PatientFormComponent },
    { path: 'cons/:idPatient' , component : ConsultationFormComponent},
    { path: 'staff' , component : StaffComponent}
  
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);