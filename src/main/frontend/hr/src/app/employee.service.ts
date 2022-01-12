import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import {HttpClient}from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})


export class EmployeeService {
  private sortEmployeeByNameURL = '/api/v1/employees/sort-by-name';
  private sortEmployeeBySurnameURL ='/api/v1/employees/sort-by-surname';
private findBySurnameURL ='/api/v1/employees/surname';


  private baseURL= '/api/v1/employees';
  constructor(private httpClient: HttpClient) { }

  getEmployee(id: number): Observable<Employee> {
    const url = `${this.baseURL}/${id}`;
    return this.httpClient.get<Employee>(url);
  }
  getEmployeesList():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseURL);
  }
  sortByName():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.sortEmployeeByNameURL);
}
sortBySurname():Observable<Employee[]>{
  return this.httpClient.get<Employee[]>(this.sortEmployeeBySurnameURL);
}
addEmployee(employee: Employee): Observable<any> {
  return this.httpClient.post(this.baseURL, employee);
}

updateEmployee(id: number,employee: Employee): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${id}`,employee);
}
deleteEmployee(id: number): Observable<Employee> {
  return this.httpClient.delete<Employee>(`${this.baseURL}/${id}`);
}
findEmployeesBySurnameLike(surname:string):Observable<Employee[]>{
  return this.httpClient.get<Employee[]>(`${this.findBySurnameURL}/${surname}`);
}
}
