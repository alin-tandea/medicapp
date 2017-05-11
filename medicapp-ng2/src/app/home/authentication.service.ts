import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Credentials } from './credentials';
import 'rxjs/add/operator/map'
import { Staff } from '../staff-accounts/staff' 

@Injectable()
export class AuthenticationService {
    public token: string;
    public info : Credentials;
    public staff : Staff;
    headers = new Headers({
                'Content-Type': 'application/json'
                 });
    constructor(private http: Http) {
        // set token if saved in local storage
        var currentUser = localStorage.getItem('currentUser');
        this.token = localStorage.getItem('token');
    }
 
    login(username: string, password: string): Observable<boolean> {
        console.log(JSON.stringify(this.staff ));
        return this.http.get("http://localhost:8080/medicapp/accounts/login/" + username +  "+" + password)
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
               
                try {
                    console.log(JSON.stringify(response.json()))
                    var credentials = JSON.parse(JSON.stringify(response.json()))
                } catch (error) {
                    return null;
                }
                
                
                if (credentials) {
                    // set token property
                    this.token = credentials.token
                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(credentials));
                    localStorage.setItem('token' , this.token);
                    localStorage.setItem('accountType', credentials.accountType);
                    localStorage.setItem('id' , credentials.id);
                    // return true to indicate successful login
                    return true;
                } else {
                    // return false to indicate failed login
                    return false;
                }
            });
    }
 
    logout(): void {
        // clear token remove user from local storage to log user out
        this.token = null;
        localStorage.removeItem('currentUser');
        localStorage.removeItem('accountType');
        localStorage.removeItem('id');
    }
}