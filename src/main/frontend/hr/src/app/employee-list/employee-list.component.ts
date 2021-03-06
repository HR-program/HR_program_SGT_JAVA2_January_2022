import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

import { Location } from '@angular/common';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})

export class EmployeeListComponent implements OnInit {
  selected: string ="--Choose option--";
  employees: Employee[] =[];
  totalLength: any;
  page: any=1;
  pageSizes = [10, 15, 20];
  totalElements =0;
  noOfRows =10;

  constructor(private employeeService: EmployeeService,

private location: Location,
   ) { }

  ngOnInit(): void {
    this.getEmployees();
    document.getElementById('goToLastPage').hidden = true;
  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data =>{
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
