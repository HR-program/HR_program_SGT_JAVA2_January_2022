import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  popoverTitle = 'Delete Employee';
  popoverMessage = 'Are you sure';
  confirmClicked = false;
  cancelClicked = false;
  employee: Employee = new Employee;

  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    // private location: Location,
    private router: Router

  ) { }

  ngOnInit(): void {
    this.getEmployee();
  }

  getEmployee(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.employeeService.getEmployee(id)
      .subscribe(data=>{this.employee = data
        console.log(data);
      })
  }
  deleteEmployee():void{
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.employeeService.deleteEmployee(id)
    .subscribe(
      response => {
        console.log(response);
  
        
        setTimeout(() =>this.router.navigate(['search-employees']),500);
      },
      error => {
        console.log(error);
      });
  }

  
  openUpdateEmplyeeScreen(id: any){
    
    this.router.navigate(['update-employee', id]) ;
  
  }

  goToEmployeesChildren(id:any){
    this.router.navigate(['employees-children',id]);
  }
  }


