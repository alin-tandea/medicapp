import {Component , OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { ConsultationService } from "../consultation/consultation.service"
import { Consultation } from '../consultation/consultation'

import { Drug } from "./drug"

@Component({
    selector : 'med-comp',
    templateUrl: './medic.component.html',
    
})

export class ConsultCompletePage implements OnInit{

    id : number;
    obs : string = "";
    idstaff;
    drugs : Drug[] = [];

    show = false;
    constructor(
        private _router : Router,
        private _route : ActivatedRoute,
        private _consultationService : ConsultationService){}

    ngOnInit(){
            this.idstaff = localStorage.getItem("id");
            var id = this._route.params.subscribe(params =>{
                var id = params['idCons'];
                this.id = id;
            });
            this._consultationService.getAllDrugs()
                .subscribe(res => this.drugs = res)
    }

    prescript(){
        this.show = !this.show;
    }

    save(){
        this._consultationService.completeConsult(this.id , this.obs)
            .subscribe(data => data)
    }
}