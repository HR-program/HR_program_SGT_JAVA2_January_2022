import { Injectable } from '@angular/core';

import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class DataSharingService {

 private passingArraySource = new BehaviorSubject<any>(Employee);
 passingArray$ = this.passingArraySource.asObservable();

  constructor() {}

    sendMessage(message:any){
this.passingArraySource.next(message);
    }

}




  
