import { Injectable } from '@angular/core';
import {HttpClient}from '@angular/common/http'
import { Observable } from 'rxjs';
import { Child } from './child';
import { Employee } from './employee';


@Injectable({
  providedIn: 'root'
})
export class ChildService {

 private baseURL= '/api/v1/children';
 private addChildURL='/api/v1/employees/children';
private addChildURL2 = '/api/v1/children/employee';
//  /api/v1/children/employee/{id}

  constructor(private httpClient: HttpClient) { }

  getChildrenList():Observable<Child[]>{
    return this.httpClient.get<Child[]>(this.baseURL);
  }

 
  addChild(child: Child):Observable<Object>{
    return this.httpClient.post(this.baseURL,child);
  }

  addEmployeesChild(child:Child, employee:Employee):Observable<Object>{
return this.httpClient.post(this.addChildURL,child);
  }

  

    addEmployeesChild2(child:Child, employee:Employee):Observable<any>{

 return  this.httpClient.post(this.addChildURL,
    {
        "childPersonalCode: ": "child.childPersonalCode",
        "childDateOfBirth: ": "child.childDateOfBirth",
        "childName: ": "child.childName",
        "childSurname: ":"child.childSurname",
        "employee: ": "this.employee"
    })}

    


    
  updateChild(id:number,child:Child): Observable<Object>{
return this.httpClient.put(`${this.baseURL}/${id}`, child);
  }

  deleteChild(id:number):Observable<Child>{
    return this.httpClient.delete<Child>(`${this.baseURL}/${id}`);
  }

  getChildrenByEmployessID(id:number):Observable<Child[]>{
    return this.httpClient.get<Child[]>(`${this.addChildURL2}/${id}`);
  }

  addEmployeesChild3(child:Child, id:number):Observable<any>{
    return this.httpClient.post(`${this.addChildURL2}/${id}`,child);
      }
      addEmployeesChild4(child:Child, id:number):Observable<any>{

        return  this.httpClient.post(`${this.addChildURL2}/${id}`,
           {
               "childPersonalCode: ": "child.childPersonalCode",
               "childDateOfBirth: ": "child.childDateOfBirth",
               "childName: ": "child.childName",
               "childSurname: ":"child.childSurname"
               
           })}
       
}