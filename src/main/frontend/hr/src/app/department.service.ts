import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from './department';


@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  baseURL ='api/v1/departments';
  addURL ='api/v1/departments/add';

 department: Department = new Department();

  constructor(private httpClient: HttpClient) { }

  getDepartmentsList():Observable<Department[]>{
    return this.httpClient.get<Department[]>(this.baseURL);
  }

  addDepartment(department: Department):Observable<Department>{
    console.log(department)
    return this.httpClient.post<any>(this.addURL,department,this.httpOptions);
  }
    


 


  updateDepartment(id:number,department: Department): Observable<Object>{
return this.httpClient.put(`${this.baseURL}/${id}`, department);
  }

  deleteDepartment(id:number):Observable<Department>{
    return this.httpClient.delete<Department>(`${this.baseURL}/${id}`);
  }

  getDepartment(id: number): Observable<Department> {
    const url = `${this.baseURL}/${id}`;
    return this.httpClient.get<Department>(url);
  }
}
