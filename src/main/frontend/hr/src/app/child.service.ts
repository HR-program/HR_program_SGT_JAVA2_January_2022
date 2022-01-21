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
private sortByAgeURL = '/api/v1/children/sort-by-age';
private sortByAgeDescURL = 'api/v1/children/sort-by-age-desc';
private ageLessThan13URL = 'api/v1/children/age';
private orderByParent ='api/v1/children/group-by-parent'

  constructor(private httpClient: HttpClient) { }

  getChildrenList():Observable<Child[]>{
    return this.httpClient.get<Child[]>(this.baseURL);
  }

 getChildById(id:number):Observable<Child>{
   return this.httpClient.get<Child>(`${this.baseURL}/${id}`)
 }

sortChildrenByAge():Observable<Child[]>{
  return this.httpClient.get<Child[]>(this.sortByAgeURL)
}

sortChildrenByAgeDesc():Observable<Child[]>{
  return this.httpClient.get<Child[]>(this.sortByAgeDescURL)
}

getChildrenByAgeLesThan13(age:number):Observable<Child[]>{
  return this.httpClient.get<Child[]>(`${this.ageLessThan13URL}/${age}`)
}

orderChildernByParentsSurname():Observable<Child[]>{
  return this.httpClient.get<Child[]>(this.orderByParent)
}

  addChild(child: Child):Observable<Object>{
    return this.httpClient.post(this.baseURL,child);
  }

  addEmployeesChild(child:Child, employee:Employee):Observable<Object>{
return this.httpClient.post(this.addChildURL,child);
  }

    addEmployeesChild2(child:Child, employee:Employee):Observable<any>{

 return this.httpClient.post(this.addChildURL,
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
