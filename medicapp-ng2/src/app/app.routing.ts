import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule }   from '@angular/router';

import { PatientComponent } from "./patients/patient.component"
import { PatientFormComponent } from './patients/patient-form.component';
import { ConsultationFormComponent } from './consultation/consultation-form.component'
import { StaffComponent } from "./staff-accounts/staff.component"
import { StaffFormComponent } from "./staff-accounts/staff-form.component"
import { WorkComponent } from './medic/work.component'
import { ConsultationComponent } from "./consultation/consultation.component"
import { LoginComponent } from './home/login.component';
import { AuthGuard } from './home/auth.guard';
import { MedicComponent } from './medic/medic.component'
import { AdminAuthGuard } from "./home/admin-auth.guard"
import { MedicAuthGuard } from "./home/medic-auth.guard"
import { SecretaryAuthGuard } from "./home/secretary-auth.guard"
import { MedicOtherComponent } from "./medic/medic-other.component"

const appRoutes: Routes = [
    { path: 'login', pathMatch: 'full', component: LoginComponent },
    { path: 'patients', component: PatientComponent ,  canActivate: [SecretaryAuthGuard]},
    { path: 'patients/new' , component : PatientFormComponent ,  canActivate: [SecretaryAuthGuard]},
    { path: 'patients/:idPatient' , component : PatientFormComponent ,  canActivate: [SecretaryAuthGuard]},
    { path: 'cons/:idPatient' , component : ConsultationFormComponent,  canActivate: [SecretaryAuthGuard]},
    { path: 'staff' , component : StaffComponent ,  canActivate: [AdminAuthGuard]},
    { path: 'staff/new' , component : StaffFormComponent ,  canActivate: [AdminAuthGuard]},
    { path: 'staff/:idStaff' , component : StaffFormComponent,  canActivate: [AdminAuthGuard]},
    { path: 'schedule/:idStaff' , component : WorkComponent,  canActivate: [MedicAuthGuard]},
    { path: 'consultations' , component :ConsultationComponent ,  canActivate: [MedicAuthGuard]},
    { path: 'appointments/:idStaff' , component :MedicOtherComponent ,  canActivate: [MedicAuthGuard]},
    { path: 'medic/:idStaff' , component :MedicComponent ,  canActivate: [MedicAuthGuard]},
    { path: '**', redirectTo: 'login' },
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);