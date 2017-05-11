import {Component , OnInit} from '@angular/core';
import {MaterializeDirective} from "angular2-materialize";
import { Router, ActivatedRoute } from '@angular/router';

import { WorkService } from './work.service'
import { WorkSchedule } from './work' 
  
@Component({
    selector : 'work-comp',
    templateUrl : './work.component.html'
})

export class WorkComponent implements OnInit{
    
    idStaff : number;

    schedule : WorkSchedule[] = [] ;
    show: any[] = [];
    constructor(
        private _router : Router,
        private _route : ActivatedRoute,
        private _workService : WorkService){}

    ngOnInit(){
        var id = this._route.params.subscribe(params =>{
            var id = params['idStaff'];
            this.idStaff = id;
            console.log(id);
            this._workService.getMedicSchedule(id)
                .subscribe((data) => {
                    this.schedule = data
                    console.log(data)
            })
        });

    }
    save(s){
        if(s.startHour >= s.endHour){
            alert("The starting work hour cannot be greater than the ending work hour")
            s.startHour = -1;
            s.endHour = -1;
        }else{
            this.show[s.workday] = !this.show[s.workday];
            var result = this._workService.updateSchedule( s);
            result.subscribe(null);
            console.log(this.schedule);
        }
    }
}