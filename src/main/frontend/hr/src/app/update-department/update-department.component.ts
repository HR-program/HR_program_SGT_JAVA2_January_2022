import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from '../department';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-update-department',
  templateUrl: './update-department.component.html',
  styleUrls: ['./update-department.component.css']
})
export class UpdateDepartmentComponent implements OnInit {

  department:Department = new Department();
id:number;
  constructor(private departmentService:DepartmentService,
    private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.getDepartement();
    
  }

  onSubmit(){
this.updateDepartment();
  }

  goBack(){

  }

  getDepartement():void{
    this.id = this.route.snapshot.params['id'];
    this.departmentService.getDepartment(this.id).subscribe(data=>{this.department=data;},
      
      error=>console.log(error)); 
      
  }


  

  updateDepartment():void{
    this.id = this.route.snapshot.params['id'];
    this.departmentService.updateDepartment(this.id,this.department).subscribe((data)=>{
      console.log(this.department);
this.goToDepartmetList();
      
    },error=>console.log(error));
  }

  goToDepartmetList(){
    this.router.navigate(['departments']);
  }


    // updateEmployee():void{
    //   // this.id = this.route.snapshot.params['id'];
      
    //   this.employeeService.updateEmployee(this.id,this.employee).subscribe(data=>  {
    //     this.goToEmployeesDetails();
    //   },
  
    //     error=>console.log(error));
    
    // }

}
