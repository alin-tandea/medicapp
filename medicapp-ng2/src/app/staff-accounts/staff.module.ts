import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';

import { StaffService } from './staff.service'
import { StaffComponent } from './staff.component'

@NgModule({
        imports:[
            CommonModule,
            FormsModule,
            ReactiveFormsModule,
            RouterModule,
            HttpModule,
    ],
    declarations: [
            StaffComponent,

    ],
    exports: [
            StaffComponent
    ],
    providers: [
            StaffService
    ] 
})

export class StaffModule{}