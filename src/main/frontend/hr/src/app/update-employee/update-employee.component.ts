import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Location } from '@angular/common';
import { Department } from '../department';
import { DepartmentService } from '../department.service';

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

  constructor(private employeeService: EmployeeService,
    private departmentService: DepartmentService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    
    ) { }

  ngOnInit(): void {
    this.getEmployee();
    this.getDepartments();
// this.getemployeeDepartment();
  }

  // getemployeeDepartment(){
  //   this.employeeDepartment = this.employee.department.id;
  //   if(this.employee.department===null){
  //     this.employeeDepartment=Department.find(x=>x!==undefined);
  //   }else{this.employeeDepartment=this.employee.department.id}

  // }






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
      //SECOND WAY const id = Number(this.route.snapshot.paramMap.get('id'));
      this.id = this.route.snapshot.params['id'];
      this.employeeService.getEmployee(this.id).subscribe(data=>{this.employee=data 
        // console.log(data)
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
        // this.id = this.route.snapshot.params['id'];
        this.router.navigate(['employees',this.id]);
    
      }
      goBack(): void {
        this.location.back();
         
      }
    }

