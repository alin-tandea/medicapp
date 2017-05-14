import {Component , OnInit} from '@angular/core';
import {MaterializeDirective} from "angular2-materialize";

import { PatientService } from "./patient.service"
import { Patient } from './patient'
import { LoadingAnimateModule, LoadingAnimateService } from 'ng2-loading-animate';

@Component({
    selector : 'patient-comp',
    templateUrl: './patient.component.html',
    
})

export class PatientComponent implements OnInit{

    patients : Patient[] = [];
    searchParameter :any;
    radioButtonValue :any = 1;
    data_item;
    constructor(private _patientService : PatientService,
                private loadService : LoadingAnimateService){}

    ngOnInit(){
        this._patientService.getAllPatients()
            .subscribe((patients) =>{ 
                this.patients = patients,
                this.loadService.setValue(false);
                console.log(this.patients);
        });
    }

    search(){
        if(this.searchParameter){
        this._patientService.searchBy(this.radioButtonValue , this.searchParameter)
            .subscribe((patients) => {
                this.patients = patients
        })
        }else{
        this._patientService.getAllPatients()
            .subscribe((res) =>{ 
                this.patients = res
        });
        }
    }

    deletePatient(){

    }
}