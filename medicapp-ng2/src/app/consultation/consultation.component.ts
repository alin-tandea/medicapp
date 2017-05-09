import {Component , OnInit} from '@angular/core';


import { ConsultationService } from "./consultation.service"
import { Consultation } from './consultation'


@Component({
    selector : 'cons-comp',
    templateUrl: './consultation.component.html',
    
})

export class ConsultationComponent implements OnInit{

    consultations : Consultation[] = [];
    searchParameter :any;
    radioButtonValue :any = 1;
    data_item;
    constructor(private _consultationService : ConsultationService){}


    ngOnInit(){

    }
}