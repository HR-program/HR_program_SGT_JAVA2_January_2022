import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from '../department';
import { DepartmentService } from '../department.service';



@Component({
  selector: 'app-add-department',
  templateUrl: './add-department.component.html',
  styleUrls: ['./add-department.component.css']
})
export class AddDepartmentComponent implements OnInit {

 response: Response = new Response;
  department: Department = new Department();
  newDepartment: Department = new Department();
  httpOptions: any;
 
  
  constructor(private departmentService:DepartmentService,
    private router:Router,
     
    ) { }

   
  ngOnInit(): void {

      }

onSubmit(){
      this.addDepartment();
      
      this.goToDepartmentList();
       
  }
  addDepartment(){
    console.log(this.department)
   
    this.departmentService.addDepartment(this.department).subscribe(res => {
      console.log(res);
      
    },
    error => {
      console.log(error);
    });

  }
  

  goToDepartmentList(){
    setTimeout(() => this.router.navigate(['departments']),350);
    setTimeout(() => document.getElementById('goToLastPage').click(), 500)


  }


    }
  

  




