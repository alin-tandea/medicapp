import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
 
import { AuthenticationService } from './authentication.service'
 import {AuthGuard } from '../home/auth.guard';

@Component({
    selector : 'login-comp',
    templateUrl: 'login.component.html',
    providers : [AuthenticationService , AuthGuard]
})
 
export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    error = '';
    id;
    private accType;
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
        ) { }
 
    ngOnInit() {
        // reset login status
       this.authenticationService.logout();
    }
 
    login() {
        this.loading = true;
        console.log(this.model)
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(result => {
                if (result === true) {
                    // login successful
                    this.accType = localStorage.getItem('accountType');
                    this.id = localStorage.getItem('id');
                    console.log(this.accType)
                    if(this.accType == 0){
                        this.router.navigate(['staff'])
                    }else  if(this.accType == 1){
                        this.id = localStorage.getItem('id');
                        console.log(this.id);
                        this.router.navigate(['medic' ,this.id ])
                    } else {
                        this.router.navigate(['patients'])
                    }
                    // login failed
                    this.error = 'Username or password is incorrect';
                    alert(this.error);
                    this.loading = false;
                }
            });
    }
}