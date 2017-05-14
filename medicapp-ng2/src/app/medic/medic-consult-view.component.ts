import {Component , OnInit} from '@angular/core';
import {MaterializeDirective} from "angular2-materialize";

import { PatientService } from "../patients/patient.service"
import { ConsultationService } from "../consultation/consultation.service"
import { Patient } from '../patients/patient'
import { Consultation } from '../consultation/consultation'


@Component({
    selector : 'patient-comp',
    templateUrl: './medic-consult-view.component.html',
    
})

export class MedicConsult implements OnInit{
    patients : Patient[] = [];
    consultations : Consultation[] =[];
    searchParameter :any;
    active  = false;
    activeCons = false;
     constructor(
         private _consultService : ConsultationService,
         private _patientService : PatientService){}

    ngOnInit(){

    }

    seeConsult(id){
        this.activeCons  = true;
        this._consultService.getConsultationsPatient(id)
            .subscribe((data)=> {
                this.consultations = data
                console.log(data)
            })
    }

    search(){
        this.active = true;
        if(this.searchParameter){
        this._patientService.searchBy(1,this.searchParameter)
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
}