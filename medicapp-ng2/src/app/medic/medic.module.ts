import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';

import { WorkService } from './work.service'
import { WorkComponent } from './work.component'

@NgModule({
    imports:[
            CommonModule,
            FormsModule,
            ReactiveFormsModule,
            RouterModule,
            HttpModule,
    ],
    declarations: [
            WorkComponent
    ],
    exports: [
            WorkComponent
    ],
    providers: [
            WorkService
    ]         
})

export class MedicModule{}