import { Injectable } from '@angular/core';
import { Http  , Headers } from '@angular/http';
import { Patient } from './patient'

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch'; 
import { Observable } from 'rxjs/Rx';

@Injectable()
export class PatientService{
    headers = new Headers({
                'Content-Type': 'application/json'
                 });
    private url : string = "http://localhost:8080/medicapp/patients"
    constructor(private _http : Http){}

    getAllPatients(){
        return this._http.get(this.url)
            .map(res => res.json());
    }

    searchBy(value , text){
        return this._http.get(this.buildUrl(value , text))
            .map(res => res.json());
    }

    addPatient(patient){
        return this._http.post(this.url + "/new" , JSON.stringify(patient) , {headers: this.headers});
    }

    updatePatient(id , patient){
        return this._http.put(this.url + "/update/" + id, JSON.stringify(patient) , {headers: this.headers});
    }

    getPatient(id){
        return this._http.get(this.url + "/" + id)
            .map(res => res.json())
    }
    buildUrl(option , text){
        if(option == 1){
            return this.url+"/name/"+ text;
        }else if(option == 2){
            return this.url+"/cnp/"+text;
        }
    }
}