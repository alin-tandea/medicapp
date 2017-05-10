import {Component , OnInit} from '@angular/core';
import {MaterializeDirective} from "angular2-materialize";

import { Staff } from "./staff"
import { StaffService } from "./staff.service"

@Component({
    selector : 'acc-comp',
    templateUrl : './staff.component.html'
})

export class StaffComponent implements OnInit{

    staffAccounts : Staff[] = [];

    constructor(private _staffService : StaffService){}

    ngOnInit(){
        this._staffService.getAllAccounts()
            .subscribe((res) => {
                this.staffAccounts = res;
                console.log(this.staffAccounts);
            })
    }
    deleteAccount(account){
        if (confirm("Are you sure you want to delete " + account.username + "?")){
            var index = account.idstaff;
            this._staffService.deleteAccount(index)
                .subscribe(null
          )
        } 
    }  
}