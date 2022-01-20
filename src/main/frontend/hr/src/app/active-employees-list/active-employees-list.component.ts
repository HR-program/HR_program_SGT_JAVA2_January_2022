import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

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
    this.employeeService.sortByName().subscribe
    (data =>{
      this.employees = data;
      console.log (data);
    })}

  sortBySurname():void{
    this.employeeService.sortBySurname().subscribe
    (data =>{
      this.employees = data;
      console.log (data);
    })}

 selectedOption(){

    switch(this.selected) {
      case "3":
         // if modo 1 is selected do something.
         break;
      case "1":
         this.sortBySurname();
         break;
      case "2":
         this.sortByName();
         break;

    }
  }
  goBack(): void {
    this.location.back();
  }
}

