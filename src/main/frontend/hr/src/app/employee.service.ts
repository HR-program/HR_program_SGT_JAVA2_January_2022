import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import {HttpClient}from '@angular/common/http'
import { Department } from './department';

@Injectable({
  providedIn: 'root'
})


export class EmployeeService {
  private addURL ='/api/v1/departments/add';
  private sortEmployeeByNameURL = '/api/v1/employees/sort-by-name';
  private sortEmloyeeBySurnameURL ='/api/v1/employees/sort-by-surname';
private findBySurnameURL ='/api/v1/employees/surname';
private findByNameURL='/api/v1/employees/name';
private findByPersonalCodeURL='api/v1/employees/personal-code';
 
  private baseURL= '/api/v1/employees';
  constructor(private httpClient: HttpClient) { }

  getEmployee(id: number): Observable<Employee> {
    const url = `${this.baseURL}/${id}`;
    return this.httpClient.get<Employee>(url);
  }
  getEmployeesList():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseURL);
  }
  sortByname():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.sortEmployeeByNameURL);
}
sortBySurname():Observable<Employee[]>{
  return this.httpClient.get<Employee[]>(this.sortEmloyeeBySurnameURL);
}
addEmployee(employee: Employee): Observable<any> {
  return this.httpClient.post(this.baseURL, employee);
}

addDepartment(department: Department):Observable<any>{
  return this.httpClient.post(this.addURL,department);
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
findEmployeesByNameLike(name:string):Observable<Employee[]>{
  return this.httpClient.get<Employee[]>(`${this.findByNameURL}/${name}`);
}
findEmployeesByPersonalCodeLike(personalCode:string):Observable<Employee[]>{
  return this.httpClient.get<Employee[]>(`${this.findByPersonalCodeURL}/${personalCode}`);
}
}
