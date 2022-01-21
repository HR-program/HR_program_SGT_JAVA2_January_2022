import {FormControl, FormGroup, Validators} from '@angular/forms';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ChildService } from '../child.service';
import { Department } from '../department';
import { DepartmentService } from '../department.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})

export class AddEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  departments: Department[]=[];
  id!: number;
  page: any=1;
  colorTheme = 'theme-default'
 bsConfig?: Partial<BsDatepickerConfig>;

  applyTheme(){
    this.bsConfig =  { containerClass: this.colorTheme,dateInputFormat: 'DD/MM/YYYY' }
  }

  constructor(private employeeService: EmployeeService,
    private router:Router,
    private route: ActivatedRoute,
    private departmentService:DepartmentService,
    private childService: ChildService,
    private location: Location,
    ) { }

  ngOnInit(): void {
    this.getDepatments();
    this.applyTheme();
  }

  getDepatments(){
    this.departmentService.getDepartmentsList().subscribe(data=>{
      this.departments=data;
console.log(data);
},
error=> console.log(error));
}
  addEmployee(){
    this.employeeService.addEmployee( this.employee).subscribe(data=>{
      console.log(data);
      this.goToEmployeesList();
    },
   error=> console.log(error));
  }

  goToEmployeesList(){
  this.router.navigate(['employees']);
  setTimeout(() => document.getElementById('goToLastPage').click(), 350)
  }

  goToEmployeesScreen(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.router.navigate(['employees', id]);
    }

    onSubmit(){
      this.addEmployee();
    }

    goBack(): void {
      this.location.back();
    }
}
