import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataSharingService } from '../data-sharing.service';
import { Department } from '../department';
import { DepartmentService } from '../department.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css']
})
export class SearchEmployeeComponent implements OnInit {
  departments: Department[]=[];
  department:Department =  new Department();
employee:Employee = new Employee();
searchName:string;
surname:string;
employees: Employee[] =[];
totalLength: any;
departmentId:number;
id: number;
selectedDepartment:number;
  constructor(private employeeService: EmployeeService,
    private router: Router,
    private dataSharingService: DataSharingService,
    private departmentService: DepartmentService) { }

  ngOnInit(): void {
    this.getDepatments();

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
      console.log(this.employees);
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
    console.log(this.employees);
    this.dataSharingService.sendMessage(this.employees);

    this.totalLength=data.length;

    this.goToSearchedList();
           })
}

findEmployeesByPersonalCode(){

  this.employeeService.findEmployeesByPersonalCodeLike(this.employee.personalCode).subscribe(data =>{
    this.employees = data;
    console.log(this.employees);
    this.dataSharingService.sendMessage(this.employees);

    this.totalLength=data.length;

    this.goToSearchedList();
           })
}

goToSearchedList(){

  this.router.navigate(['searched-employees']);
}

onSubmitDepartment(){
  console.log(this.selectedDepartment);
  this.employeesByDepartmentsId();
}

getDepatments(){
  this.departmentService.getDepartmentsList().subscribe(data=>{
    this.departments=data;
    this.totalLength=data.length;
console.log(data);
  },error=>console.log(error));

}

employeesByDepartmentsId(){
  this.employeeService.employeesByDepartmentsId(this.selectedDepartment).subscribe(data=>{
    this.employees = data;
    console.log(data);
    this.dataSharingService.sendMessage(this.employees);

    this.totalLength=data.length;

    this.goToSearchedList();
  },error=>console.log(error));
}


}



