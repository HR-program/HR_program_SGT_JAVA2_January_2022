import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataSharingService } from '../data-sharing.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css']
})
export class SearchEmployeeComponent implements OnInit {
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
onSubmit(){
  // console.log(this.employee.surname);
  this.findEmployeesBySurname();
}

   findEmployeesBySurname(){
    //  console.log(this.employee.surname)
    // console.log(this.employee.surname);

    this.employeeService.findEmployeesBySurnameLike(this.employee.surname).subscribe(data =>{
      this.employees = data;
      console.log(this.employees);
      this.dataSharingService.currentSearchedEmployees;
      console.log(this.dataSharingService.currentSearchedEmployees);
      this.totalLength=data.length;

      this.goToSearchedList();
             })
}

goToSearchedList(){
  this.router.navigate(['searched-employees']);
}
}
