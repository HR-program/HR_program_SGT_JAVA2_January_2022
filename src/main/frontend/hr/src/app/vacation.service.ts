import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vacation } from './vacation';

@Injectable({
  providedIn: 'root'
})
export class VacationService {
  baseURL= '/api/v1/vacation/employee/'
  

  constructor(private httpClient: HttpClient) {}
 
  addVacationTable(vacation:Vacation, id:number): Observable<any>{
    return this.httpClient.post(`${this.baseURL}/${id}`, vacation);
  }



}