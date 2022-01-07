import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class DataSharingService {

  private employees = new BehaviorSubject<any>([]);
  currentSearchedEmployees = this.employees.asObservable();
  

  constructor() {

}

// searchedEmployees2(eml: Object){
//   this.searchedEmployees.next(eml);
}

  
