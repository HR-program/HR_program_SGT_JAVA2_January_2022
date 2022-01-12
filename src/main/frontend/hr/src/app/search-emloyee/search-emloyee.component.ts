import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataSharingService } from '../data-sharing.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-search-emloyee',
  templateUrl: './search-emloyee.component.html',
  styleUrls: ['./search-emloyee.component.css']
})
export class SearchEmloyeeComponent implements OnInit {
employee:Employee = new Employee();
searchName:string;
surname:string;
employees: Employee[] =[];
totalLength: any;
  constructor(private employeeService: EmployeeService,
    private router: Router,
    private dataSharingService: DataSharingService) { }

  ngOnInit(): void {
  }
onSubmitName(){
  // console.log(this.employee.surname);

  this.findEmployeesByName();

  
}
onSubmitSurName(){
  
  this.findEmployeesBySurname();
}
onSubmitPersonalCode(){
  
  this.findEmployeesByPersonalCode();
}



   findEmployeesBySurname(){
    //  console.log(this.employee.surname)
    // console.log(this.employee.surname);
   
    this.employeeService.findEmployeesBySurnameLike(this.employee.surname).subscribe(data =>{
      this.employees = data;
      // console.log(this.employees);
      this.dataSharingService.sendMessage(this.employees);
      
      this.totalLength=data.length;
 
      this.goToSearchedList();
             })
}

findEmployeesByName(){
  //  console.log(this.employee.surname)
  // console.log(this.employee.surname);
 
  this.employeeService.findEmployeesByNameLike(this.employee.name).subscribe(data =>{
    this.employees = data;
    // console.log(this.employees);
    this.dataSharingService.sendMessage(this.employees);
    
    this.totalLength=data.length;

    this.goToSearchedList();
           })
}

findEmployeesByPersonalCode(){

  this.employeeService.findEmployeesByPersonalCodeLike(this.employee.personalCode).subscribe(data =>{
    this.employees = data;

    this.dataSharingService.sendMessage(this.employees);
    
    this.totalLength=data.length;

    this.goToSearchedList();
           })
}


goToSearchedList(){
  
  this.router.navigate(['searched-employees']);
}
}
