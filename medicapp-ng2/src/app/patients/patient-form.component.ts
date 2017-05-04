import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { Patient } from './patient';
import { PatientService } from './patient.service'


@Component({
    selector : 'patient-form',
    templateUrl : './patient-form.component.html'
})

export class PatientFormComponent implements OnInit{

    patient : Patient = new Patient();
    form : FormGroup;
    title : string;
    private idClient;

    constructor(
        _formBuilder : FormBuilder,
        private _router : Router,
        private _route : ActivatedRoute,
        private _patientService : PatientService
    ){
        this.form = _formBuilder.group({
            name: ['' ,[
                Validators.required,
                Validators.minLength(3),
                Validators.maxLength(45)
            ]],
            idcardNumber: ['',[
                Validators.required,
                Validators.minLength(8),
                Validators.maxLength(8),
                Validators.pattern('[A-Z][A-Z]([0-9])*')
    
            ]],
            cnp: ['',[
                Validators.required,
                Validators.pattern('[1245][0-9][0-9][01][0-9][0-3][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
    
            ]],
            birthdate : ['',[
            ]],
            address: ['',[
                Validators.required,
                Validators.minLength(3),
                Validators.maxLength(45)
    
            ]]
           

        });
    }
    ngOnInit(){
        var id = this._route.params.subscribe(params =>{
            var id = params['idPatient'];
            this.idClient = id;
            this.title = id ? 'Edit patient info' : 'New patient';

            if(!id) return;

            this._patientService.getPatient(id)
                .subscribe(
                    data => this.patient = data
                )
        });
    }

    save() {

        var result;
        this.patient = this.form.value;
        if (this.idClient){
            result = this._patientService.updatePatient(this.idClient , this.patient);
        } else {
            console.log(this.patient);
            result = this._patientService.addPatient(this.patient);
        }
        result.subscribe(
            (data) => {
                this._router.navigate(['patients#patients'])
            },
            (err) => {
                alert("A patient with that CNP or ID Card Number is already registered ")
            }
            );
  }

}