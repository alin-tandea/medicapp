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
    selector : 'med-comp',
    templateUrl: './medic.component.html',
    
})

export class MedicComponent implements OnInit{
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

            this.form = _formBuilder.group({
                hgb: ['' ,[
                    Validators.required,
                ]],
                paletets: ['' ,[
                    Validators.required,

                ]],
                vsh: ['' ,[
                    Validators.required,

                ]],
                tsh: ['' ,[
                    Validators.required,

                ]],
                mg: ['' ,[
                    Validators.required,

                ]],
                fe: ['' ,[
                    Validators.required,
                ]],
            });

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
               // console.log(this.consultations)
            })
            }


    ngOnInit(){
        this.loadingService.setValue(false);
       var id = this._route.params.subscribe(params =>{
            var id = params['idStaff'];
            this.id = id;
        });
        this._consultationService.getAllDrugs()
            .subscribe(res => this.drugs = res);
       this._consultationService.getConsultationsMedicToday(this.id)
            .subscribe((data) => {
                this.consultations = data
                console.log(this.consultations)
            })
    }

    search(){
        this._consultationService.searchDrugs(this.searchParameter)
            .subscribe(res => this.drugs = res);
    }

    generatePdf(){
        this._consultationService.generatePdf(this.selectedDrugs , this.id , this.consultation.idconsultation).subscribe(
            (res) =>{ 
               console.log(res);
               this._consultationService.getPdf()
                    .subscribe((data) => {
                        console.log(data.text().toString());
                        var bin = atob(data.text().toString());
                        var byteNumbers = new Array(bin.length);
                        for (var i = 0; i < bin.length; i++) {
                            byteNumbers[i] = bin.charCodeAt(i);
                        }
                        var byteArray = new Uint8Array(byteNumbers);
                        var blob =  new Blob([byteArray] , {type: 'application/pdf'})

                        FileSaver.saveAs(blob , "report.pdf")
                    })
            }
        )
    }

    showBloodTest(){
        this.showTest = true;
        this.showPrescript = false;

         this.consPage = true;
         this.showDis = false;
    }

    submitTest(b){
        console.log(b)
        console.log(this.bloodtest)
        console.log(this.form.value)
        this._consultationService.addBloodTest(this.consultation.idconsultation , b)
            .subscribe((data) => data)
    }


    select(drug){
        this.selected[drug.iddrug] = true;
        this.selectedDrugs.push(drug);
    }

    cancelSelection(drug){
        this.selected[drug.iddrug] = false;

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
        this._consultationService.getPatient(cons.idconsultation)
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
                            this.consultation = cons;
                            this.consPage = true;
                            this.showDis = false;
                    })
                this._consultationService.getBloodTest(cons.idconsultation)
                    .subscribe(data => this.bloodtest = data)
             } );
    }
    clear(){
        this.selected = [];
        this.selectedDrugs = [];
    }

    addDisease(idpatient , id){
        this._consultationService.addDisease(idpatient , id)  
            .subscribe((data) => {
                this._consultationService.getPatientDiseases(idpatient)
                    .subscribe(res => this.patientDiseases = res )
            })
    }

    deleteDisease(idpatient , id){
        this._consultationService.deleteDisease(idpatient , id)
            .subscribe((data) => {
                this._consultationService.getPatientDiseases(idpatient)
                    .subscribe(res => this.patientDiseases = res )
            })
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
	
	save(id){
        console.log(this.reason);
		this._consultationService.completeConsult(this.consultation.idconsultation , this.reason)
            .subscribe(data => this.data_item = data);
        this.active = false;
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