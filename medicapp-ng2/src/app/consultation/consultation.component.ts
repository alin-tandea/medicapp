import {Component , OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { ConsultationService } from "./consultation.service"
import { Consultation } from './consultation'
import {MaterializeDirective} from "angular2-materialize";

@Component({
    selector : 'cons-comp',
    templateUrl: './consultation.component.html',
    
})

export class ConsultationComponent implements OnInit{

    consultations : Consultation[] = [];
    searchParameter :any;
    radioButtonValue :any = 1;
    data_item;
    active = false;
    datepicker;
    constructor(
        private _router : Router,
        private _route : ActivatedRoute,
        private _consultationService : ConsultationService){}


    ngOnInit(){
        this._consultationService.getTodayConsultations()
            .subscribe((data) => {
                this.consultations = data
                console.log(this.consultations)
            })
    }

    checkIn(id){
        this._consultationService.checkIn(id)
            .subscribe((res)=> {
                console.log(res)
                this._router.navigate(['consultations'])
                this._consultationService.getConsultationDate(this.datepicker)
                    .subscribe((data) => {
                    this.consultations = data
                    console.log(this.consultations)
                 })
            },
            (err)=>{
                 this._router.navigate(['consultations'])
            }
            )
            this._router.navigate(['consultations'])
            
    }

    checkDate(){
        this.active =true;
        console.log(this.datepicker)
        this._consultationService.getConsultationDate(this.datepicker)
            .subscribe((data) => {
                this.consultations = data
                console.log(this.consultations)
            })
    }
}