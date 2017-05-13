import {Component , OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { ConsultationService } from "../consultation/consultation.service"
import { Consultation } from '../consultation/consultation'



@Component({
    selector : 'med-comp',
    templateUrl: './medic.component.html',
    
})

export class ConsultCompletePage implements OnInit{

    id : number;
    obs : string = "";
    constructor(
        private _router : Router,
        private _route : ActivatedRoute,
        private _consultationService : ConsultationService){}

    ngOnInit(){
            var id = this._route.params.subscribe(params =>{
                var id = params['idCons'];
                this.id = id;
            });
    }

    save(){
        this._consultationService.completeConsult(this.id , this.obs)
            .subscribe(data => data)
    }
}