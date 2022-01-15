import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
model: any = {};

constructor(
        private route: ActivatedRoute,
        private router: Router,
        private http: HttpClient
    ) { }
 ngOnInit() {
         sessionStorage.setItem('token', '');
     }

     login() {
         let url = 'http://localhost:8082/login';
         let result = this.http.post(url, {
             userName: this.model.username,
             password: this.model.password
         })
         this.http.post<Observable<boolean>>(url, {
                userName: this.model.username,
                password: this.model.password
            }).subscribe((isValid: any) => {
                if (isValid) {
                    sessionStorage.setItem(
                      'token',
                      btoa(this.model.username + ':' + this.model.password)
                    );
            	this.router.navigate(['']);
                } else {
                    alert("Authentication failed.")
                }
            });
     }
}