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

}