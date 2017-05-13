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
    selector : 'med-comp',
    templateUrl: './medic.component.html',
    
})

export class MedicComponent implements OnInit{
    show : any[] = [];
    consultations : Consultation[] = [];
    searchParameter :any;
    radioButtonValue :any = 1;
    data_item;
    id;
    datepicker;
    constructor(
        private _http : Http,
        private _router : Router,
        private _route : ActivatedRoute,
        private _consultationService : ConsultationService){
            var id = this._route.params.subscribe(params =>{
            var id = params['idStaff'];
            this.id = id;
            console.log(id)
            });
            Observable.interval(2000).switchMap(()=>
                this._http.get("http://localhost:8080/medicapp/consultations/medic/" + this.id )
                                            .map(res => res.json()))
                                .subscribe((data) => {
                this.consultations = data
                console.log(this.consultations)})
            }


    ngOnInit(){
       var id = this._route.params.subscribe(params =>{
            var id = params['idStaff'];
            this.id = id;
        });
  /*     this._consultationService.getConsultationsMedicToday(this.id)
            .subscribe((data) => {
                this.consultations = data
                console.log(this.consultations)
            })*/
    }
	
	save(){
		
	}

    checkDate(){
        console.log(this.datepicker)
        this._consultationService.getConsultationsMedic(this.id ,this.datepicker)
            .subscribe((data) => {
                this.consultations = data
                console.log(this.consultations)
            })
    }
}