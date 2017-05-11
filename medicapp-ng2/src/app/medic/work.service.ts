import { Injectable } from '@angular/core';
import { Http  , Headers } from '@angular/http';


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch'; 
import { Observable } from 'rxjs/Rx';

@Injectable()
export class WorkService{
    headers = new Headers({
                'Content-Type': 'application/json'
                 });
    private url : string = "http://localhost:8080/medicapp/schedule"
    constructor(private _http : Http){}

    getMedicSchedule(id){
        return this._http.get(this.url + "/medic/" + id)
            .map(res => res.json())
    }



    getSchedule(id){
        return this._http.get(this.url + "/" + id)
            .map(res => res.json())
    }

    addSchedule(id , schedule){
        return this._http.post(this.url + "/new/" + id , JSON.stringify(schedule) , {headers: this.headers})
            .map(res => res)
    }

    updateSchedule(schedule){
        console.log( JSON.stringify(schedule))
        return this._http.put(this.url + "/update" , JSON.stringify(schedule)  , {headers: this.headers})
            .map(res => res)
    }
}