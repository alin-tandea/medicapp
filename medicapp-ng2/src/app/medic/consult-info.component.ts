import {Component , OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { ConsultationService } from "../consultation/consultation.service"
import { Consultation } from '../consultation/consultation'
import { Http  , Headers } from '@angular/http';

import { Drug } from "./drug"
import { Disease } from "./disease"
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch'; 
import { Observable } from 'rxjs/Rx';
import { ConsultCompleteWrapper } from "./consult-wrap"
import { LoadingAnimateModule, LoadingAnimateService } from 'ng2-loading-animate';
import { Patient } from "../patients/patient"
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BloodTest } from "./bloodtest"

import * as FileSaver from "file-saver";

@Component({
    selector : 'cons-comp',
    templateUrl: './consult-info.component.html',
    
})

export class ConsultInfo implements OnInit{
    show : any[] = [];
    selected : any[] = [] ;
    consultations : Consultation[] = [];
    drugs : Drug[] = [];
    diseases : Disease[] = [];
    patientDiseases : Disease [] = []
    consultation : Consultation;
    searchParameter :any;
    radioButtonValue :any = 1;
    data_item;
    id;
    hgb : number;
    paletets : number;
    vsh: number;
    tsh: number;
    mg: number;
    fe: number;
    datepicker;
    patient : Patient;
    showDis = false;
    active = false;
    showPrescript = false;
    showTest = false;
    selectedDrugs : Drug[] = [];
    consPage= false;
    form : FormGroup;
    bloodtest : BloodTest = new BloodTest();
    reason : ConsultCompleteWrapper = new ConsultCompleteWrapper();
    constructor(
        _formBuilder : FormBuilder,
        private _http : Http,
        private _router : Router,
        private _route : ActivatedRoute,
        private loadingService : LoadingAnimateService,
        private _consultationService : ConsultationService){
            var id = this._route.params.subscribe(params =>{
            var id = params['idCons'];
            this.id = id;
            console.log(id)
            this._consultationService.getPatient(id)
            .subscribe((res) => {
                console.log(res);
                this.patient = res
                this._consultationService.getAllDiseases()
                    .subscribe((data) => {
                        this.diseases = data;
                    })
                this._consultationService.getPatientDiseases(this.patient.idpatient)
                    .subscribe((data) => {
                            this.patientDiseases = data;
                            console.log(this.patientDiseases);
                           // this.consultation = cons;
                            this.consPage = true;
                            this.showDis = false;
                    })
                this._consultationService.getBloodTest(id)
                    .subscribe(data => {
                        this.bloodtest = data
                        if(this.bloodtest != null){
                        this.hgb = this.bloodtest.hgb;
                        this.paletets= this.bloodtest.hgb;
                        this.vsh= this.bloodtest.hgb;
                        this.tsh = this.bloodtest.hgb;
                        this.mg = this.bloodtest.hgb;
                        this.fe = this.bloodtest.hgb;
                        }
                    })
                this._consultationService.getDrugConsult(id)
                    .subscribe(data => {
                        this.selectedDrugs = data;
                    })
             } );
            });
            }


    ngOnInit(){
        this.loadingService.setValue(false);
       var id = this._route.params.subscribe(params =>{
            var id = params['idStaff'];
            this.id = id;
        });
        this._consultationService.getAllDrugs()
            .subscribe(res => this.drugs = res);
    }

    showBloodTest(){
        this.showTest = true;
        this.showPrescript = false;
         this.consPage = false;
         this.showDis = false;
    }


    diseasesShow(){
        this.showPrescript = false;
        this.active = false;
         this.consPage = true;
         this.showDis = true;
         this.showTest = false;
    }

    prescript(){
        this.showPrescript = !this.showPrescript;
        this.active = false;
        this.showDis = false;
        this.showTest = false;
    }

    consult(cons){
        console.log(cons);

    }


    obs(){
        this.active = true;
        this.showPrescript = false;
        this.showDis = false;
        this.showTest = false;
    }
    cancel(){
        this.showPrescript = false;
        this.active = false;
         this.consPage = false;
         this.showDis = false;
         this.showTest = false;
    }
}