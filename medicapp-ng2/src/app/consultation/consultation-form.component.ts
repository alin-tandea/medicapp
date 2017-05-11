import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import {MaterializeDirective} from "angular2-materialize";
import * as Materialize from "angular2-materialize";


import { Consultation } from './consultation';
import { ConsultTime } from './consult-time'
import { ConsultationService } from './consultation.service'
import { Staff } from "../staff-accounts/staff"


@Component({
    selector : 'cons-form',
    templateUrl : './consultation-form.component.html'
})

export class ConsultationFormComponent implements OnInit{

    cons : ConsultTime = new ConsultTime();
    form : FormGroup;
    datepicker : String;
    radioButtonValue : number = 1;
    searchParameter : any;
    selectedMedic : Staff;
    idPatient;
    medics : Staff[] = [];
    constructor(
        _formBuilder : FormBuilder,
        private _router : Router,
        private _route : ActivatedRoute,
        private _consultationService : ConsultationService
    ){
        this.form = _formBuilder.group({
            date : ['' ,[
                Validators.required,
            ]],
            hour : ['',[
                Validators.required,
                Validators.pattern('([0-9])*')
    
            ]],
            minute : ['',[
    
            ]],

        });
    }
    ngOnInit(){
        var id = this._route.params.subscribe(params =>{
            var id = params['idPatient'];
            this.idPatient = id;
        });
    }

    save(){
        if(this.radioButtonValue == 1){
            this.cons.minute = 0;
        }else{
            this.cons.minute = 30;
        }
        this.cons.date = this.form.value.date;
        this.cons.idStaff = this.selectedMedic.idstaff;
        this.cons.idPatient = this.idPatient;
        console.log(this.cons)
        var result = this._consultationService.addConsultation(this.cons);
        console.log(result)
        result.subscribe(
            (data) => {
                this._router.navigate(['patients'])},
            (err) => {
                alert("An appointment durring the selected time already exists . Pleas try again")
            }
            )
        console.log(this.form.value)
    }

    select(medic){
        this.selectedMedic = medic;
        console.log(this.selectedMedic)
    }

    search(){
        this._consultationService.searchMedic(this.searchParameter)
            .subscribe(res => this.medics = res)
    }
}