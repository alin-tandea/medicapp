import {Component , OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { ConsultationService } from "../consultation/consultation.service"
import { Consultation } from '../consultation/consultation'
import { Http  , Headers } from '@angular/http';


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch'; 
import { Observable } from 'rxjs/Rx';

@Component({
    selector : 'med2-comp',
    templateUrl: './medic-other.component.html',
    
})

export class MedicOtherComponent implements OnInit{
    show : any[] = [];
    consultations : Consultation[] = [];
    searchParameter :any;
    radioButtonValue :any = 1;
    data_item;
    id;
    datepicker;
    active = false;
    constructor(
        private _http : Http,
        private _router : Router,
        private _route : ActivatedRoute,
        private _consultationService : ConsultationService){
            }


    ngOnInit(){
       var id = this._route.params.subscribe(params =>{
            var id = params['idStaff'];
            this.id = id;
        });
       this._consultationService.getConsultationsMedicToday(this.id)
            .subscribe((data) => {
                this.consultations = data
                console.log(this.consultations)
            })
    }

    checkDate(){
        console.log(this.datepicker)
        this._consultationService.getConsultationsMedic(this.id ,this.datepicker)
            .subscribe((data) => {
                this.consultations = data
                this.active = true;
                console.log(this.consultations)
            })
    }
}