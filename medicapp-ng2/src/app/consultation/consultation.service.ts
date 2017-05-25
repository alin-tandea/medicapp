import { Injectable } from '@angular/core';
import { Http  , Headers } from '@angular/http';
import { Consultation } from './consultation'

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch'; 
import { Observable } from 'rxjs/Rx';

@Injectable()
export class ConsultationService{
    headers = new Headers({
                'Content-Type': 'application/json'
                 });
    private url : string = "http://localhost:8080/medicapp/consultations"
    constructor(private _http : Http){}

    addConsultation(cons){
        console.log(JSON.stringify(cons))
        return this._http.post(this.url + "/add" ,JSON.stringify(cons) , {headers: this.headers})
            .map(res =>res)
    }

    searchMedic(name){
        return this._http.get("http://localhost:8080/medicapp/accounts" + "/searchname/" + name)
            .map(res => res.json())
    }

    getConsultationsMedic(id , day){
        return this._http.get("http://localhost:8080/medicapp/consultations/medic/" +id +"/"+ day)
            .map(res =>res.json())
    }
    getConsultationsMedicToday(id){
        return this._http.get("http://localhost:8080/medicapp/consultations/medic/" +id )
            .map(res =>res.json())
    }
    getConsultationDate(day){
        return this._http.get(this.url + "/date/" + day)
            .map(res => res.json())
    }
	
    completeConsult(id , obs){
        return this._http.put("http://localhost:8080/medicapp/consultations/medic/complete/" + id, JSON.stringify(obs), {headers: this.headers})
            .map(res => res)
    }

    checkIn(id){
        return this._http.get(this.url + "/checkin/" + id)
            .map(res => res)
    }

    getTodayConsultations(){
        return this._http.get(this.url + "/date/current")
            .map(res =>res.json())
    }
    getConsultationsPatient(id){
        return this._http.get(this.url + "/patient/" + id)
            .map(res=>res.json())
    }

    getAllDrugs(){
        return this._http.get("http://localhost:8080/medicapp/drugs/all")
            .map(res=>res.json())
    }

    searchDrugs(name){
        return this._http.get("http://localhost:8080/medicapp/drugs/" + name)
            .map(res=>res.json())
    }

    generatePdf(drugs , idstaff , idpatient){
        return this._http.post("http://localhost:8080/medicapp/drugs/pdf/"+idstaff +"/" + idpatient , JSON.stringify(drugs) , {headers: this.headers})
            .map(res => res)
    }

    getPdf(){
        return this._http.get("http://localhost:8080/medicapp/drugs/pdf/")
            .map(res =>res)
    }

    getPatient(id){
        return this._http.get("http://localhost:8080/medicapp/consultations/patient/cons/" + id)
            .map(res => res.json())
    }

    getAllDiseases(){
        return this._http.get("http://localhost:8080/medicapp/disease/all")
            .map(res => res.json())
    }

    getPatientDiseases(id){
        return this._http.get("http://localhost:8080/medicapp/disease/patient/" + id)
            .map(res => res.json())
    }

    addDisease(idpatient , id){
        return this._http.get("http://localhost:8080/medicapp/disease/add/"+idpatient + "/" + id)
            .map(res => res)
    }

    deleteDisease(idpatient , id){
        return this._http.delete("http://localhost:8080/medicapp/disease/delete/"+idpatient + "/" + id)
            .map(res => res)
    }

    addBloodTest(id , btest){
        console.log(JSON.stringify(btest))
        return this._http.post("http://localhost:8080/medicapp/btest/new/" + id , JSON.stringify(btest) , {headers: this.headers})
            .map(res => res)
    }

    getBloodTest(id){
        return this._http.get("http://localhost:8080/medicapp/btest/" + id) 
            .map(res => res.json())
    }
}