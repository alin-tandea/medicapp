import {Component , OnInit} from '@angular/core';

@Component({
    selector: 'navbar',
    templateUrl: './navbar.component.html'
})

export class NavbarComponent implements OnInit{
    type ;
    id;
    ngOnInit(){
        this.type = localStorage.getItem('accountType');
        this.id  = localStorage.getItem('id');
        console.log(this.type , this.id);
    }
}