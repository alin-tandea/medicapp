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

}