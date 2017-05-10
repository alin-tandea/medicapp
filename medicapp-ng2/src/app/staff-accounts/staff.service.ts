import { Injectable } from '@angular/core';
import { Http  , Headers } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch'; 
import { Observable } from 'rxjs/Rx';

@Injectable()
export class StaffService{
    headers = new Headers({
                'Content-Type': 'application/json'
                 });
    private url : string = "http://localhost:8080/medicapp/accounts"
    constructor(private _http : Http){}

    getAllAccounts(){
        return this._http.get(this.url + "/all")
            .map(res => res.json());
    }
}