import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  id!: number;
  page: any=1;
  constructor(private employeeService: EmployeeService,
    private router:Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
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
}
