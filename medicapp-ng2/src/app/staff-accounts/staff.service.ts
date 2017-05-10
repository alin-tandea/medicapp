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

    

    getAccount(id){
        return this._http.get(this.url +"/" + id)
            .map(res => res.json());
    }

    addAccount(account){
        return this._http.post(this.url + "/new", JSON.stringify(account) , {headers: this.headers})
            .map(res => res);
    }

    updateAccount(id , account){
        return this._http.put(this.url + "/update/" + id, JSON.stringify(account) , {headers: this.headers})
            .map(res => res);
    }

    deleteAccount(id){
        return this._http.delete(this.url + "/delete/" + id)
            .map(res => res)
    }
}