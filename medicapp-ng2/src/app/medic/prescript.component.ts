import {Component , OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { ConsultationService } from "../consultation/consultation.service"
import { Consultation } from '../consultation/consultation'
import { Http  , Headers } from '@angular/http';
import { Drug } from "./drug"


@Component({
    selector : 'prescript-comp',
    templateUrl: './prescript.component.html'
})

export class PrescriptComponent implements OnInit{



    ngOnInit(){
        

    }
}