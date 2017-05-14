import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { Staff } from "./staff"
import { StaffService } from "./staff.service"

@Component({
    selector : 'acc-form-comp',
    templateUrl : './staff-form.component.html'
})

export class StaffFormComponent implements OnInit{
    title : any;
    id : number;
    staff : Staff = new Staff();
    form : FormGroup;
    active = false;
    radioButtonValue : number = 1;
    constructor(
        _formBuilder : FormBuilder,
        private _router : Router,
        private _route : ActivatedRoute,
        private _staffService : StaffService
    ){
        this.form = _formBuilder.group({
            name : ['' ,[
                Validators.required,
                Validators.minLength(3)
            ]],
            username : ['',[
                Validators.required,
                Validators.minLength(3)
    
            ]],
            password : ['',[
                Validators.required,
                Validators.minLength(6)
    
            ]],


        });
    }
    ngOnInit(){
        var id = this._route.params
            .subscribe(params =>{
                var id = params['idStaff'];
                this.id = id;
                console.log(id);
                this.title = id ? 'Edit account' : 'New account'
                if(id){
                    this.active = true
                }
                if(!id)return;
                this._staffService.getAccount(id)
                    .subscribe(
                        (res) =>{ 
                            this.staff = res ,
                            this.radioButtonValue = this.staff.role
                        }
                    )
             
            });
    }

    save(){
        var result;
        this.staff = this.form.value;
        this.staff.role = this.radioButtonValue;
        if (this.id){
            result = this._staffService.updateAccount(this.id , this.staff);
        } else {
            console.log(this.staff);
            result = this._staffService.addAccount(this.staff);
        }
        result.subscribe(
            (data) => {
                this._router.navigate(['staff'])
            },
            (err) => {
                alert("An account with that username is already registered ")
            }
            );
    }
}