import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Location } from '@angular/common';
import { Department } from '../department';
import { DepartmentService } from '../department.service';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  id: number;
  departments: Department[]=[];
  employee: Employee = new Employee();
  employeeDepartment: number
  colorTheme = 'theme-default'
 bsConfig?: Partial<BsDatepickerConfig>;
  applyTheme(){
    this.bsConfig =  { containerClass: this.colorTheme,dateInputFormat: 'DD/MM/YYYY' }
  }

  constructor(private employeeService: EmployeeService,
    private departmentService: DepartmentService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    ) { }

  ngOnInit(): void {
    this.applyTheme();
    this.getEmployee();
    this.getDepartments();
  }

  getDepartments(){
    this.departmentService.getDepartmentsList().subscribe(data=>{
      this.departments=data;
console.log(data);
},
error=> console.log(error));
}
  onSubmit(){
    this.updateEmployee();
      }

    getEmployee():void{
      this.id = this.route.snapshot.params['id'];
      this.employeeService.getEmployee(this.id).subscribe(data=>{this.employee=data
        ;},
      error=>console.log(error));
      }

      updateEmployee():void{
        this.id = this.route.snapshot.params['id'];
        console.log(this.id)
        this.employeeService.updateEmployee(this.id,this.employee).subscribe(data=>  {
          this.goToEmployeesDetails();
        },
          error=>console.log(error));
      }
      goToEmployeesDetails():void{
              this.router.navigate(['employees',this.id]);
         }
      goBack(): void {
        this.location.back();
               }
    }
