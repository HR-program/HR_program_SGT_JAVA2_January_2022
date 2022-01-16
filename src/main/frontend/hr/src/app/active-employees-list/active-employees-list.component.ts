import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { SearchEmloyeeComponent } from '../search-emloyee/search-emloyee.component';
import { Location } from '@angular/common';

@Component({
  selector: 'app-active-employees-list',
  templateUrl: './active-employees-list.component.html',
  styleUrls: ['./active-employees-list.component.css']
})
export class ActiveEmployeesListComponent implements OnInit {

  selected: string ="--Choose option--";
  employees: Employee[] =[];
  totalLength: any;
  page: any=1;
  pageSizes = [10, 15, 20];
  totalElements =0;
  pageSize:number=10;
  noOfRows =10;
  
  constructor(private employeeService: EmployeeService,
 
private location: Location,
   ) { }

  ngOnInit(): void {
  
    this.getActiveEmployees();
    document.getElementById('goToLastPage').hidden = true;
  }
  private getActiveEmployees(){
    this.employeeService.getActiveEmployeesList().subscribe(data =>{
      this.employees = data;
      this.totalLength=data.length;
      console.log (data)
             })
  }
  sortByName():void{
    this.employeeService.sortByname().subscribe
    (data =>{
      this.employees = data;
      console.log (data);
    })}
    
  sortBySurName():void{
    this.employeeService.sortBySurname().subscribe
    (data =>{
      this.employees = data;
      console.log (data);
    })}
   
 selectedOption(){

    switch(this.selected) {
      case "1":
         // if modo 1 is selected do something.
         break;
      case "4":
         this.sortBySurName();
         break;
      case "5":
         this.sortByName();
         break;

    }
  }
  goBack(): void {
    this.location.back();
     
  }
}

