import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import {MaterializeDirective} from "angular2-materialize";
import * as Materialize from "angular2-materialize";


import { Consultation } from './consultation';
import { ConsultationService } from './consultation.service'


@Component({
    selector : 'cons-form',
    templateUrl : './consultation-form.component.html'
})

export class ConsultationFormComponent implements OnInit{

    cons : Consultation = new Consultation();
    form : FormGroup;
    datepicker : String;

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
                Validators.required,
                Validators.pattern('([0-9])*'),
    
            ]],

        });
    }
    ngOnInit(){
    }
}