import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Child } from '../child';
import { ChildService } from '../child.service';
import { Department } from '../department';
import { DepartmentService } from '../department.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  child: Child = new Child();

  employee: Employee = new Employee();
  departments: Department[]=[];
  id!: number;
  page: any=1;
  
  constructor(private employeeService: EmployeeService,
    private router:Router,
    private route: ActivatedRoute,
    private departmentService:DepartmentService,
    private childService: ChildService,) { }

  ngOnInit(): void {
    this.getDepatments();
  }

  getDepatments(){
    this.departmentService.getDepartmentsList().subscribe(data=>{
      this.departments=data;
console.log(data);
    })
  
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
      console.log(this.employee);
      this.addEmployee();
           
    }

    goToAddChildPage(){
      this.router.navigate(["add-child"]);
    }

    onSubmitChild(){
      console.log(this.child);
      this.addChild();
      
         
      }
  
  
  addChild(){
    this.childService.addChild( this.child).subscribe(data=>{
      console.log(data)
     
      
    },
   error=> console.log(error));
  }
  
}
