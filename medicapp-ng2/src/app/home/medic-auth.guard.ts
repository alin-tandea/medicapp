import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
 
@Injectable()
export class MedicAuthGuard implements CanActivate {
    private accType;
    constructor(private router: Router) { }
 
    canActivate() {
        this.accType = localStorage.getItem('accountType');
        console.log(this.accType);
        if ((localStorage.getItem('currentUser')) && (this.accType == 1)) {
            // logged in so return true
            return true;
        }
        // not logged in so redirect to login page
        this.router.navigate(['/login']);
        return true;
    }
}