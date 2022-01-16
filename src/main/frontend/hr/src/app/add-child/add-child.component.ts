import { Component, OnInit } from '@angular/core';
import { Child } from '../child';
import { ChildService } from '../child.service';
import { Location } from '@angular/common';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';


@Component({
  selector: 'app-add-child',
  templateUrl: './add-child.component.html',
  styleUrls: ['./add-child.component.css']
})
export class AddChildComponent implements OnInit {

child: Child = new Child();
id = this.route.snapshot.params['id'];
  employee: Employee = new Employee;
  

  constructor(private childService: ChildService,
    private location: Location,
       private route: ActivatedRoute,
    private employeeService: EmployeeService,
    
    ) { }

  ngOnInit(): void {
  }
  onSubmit(){
    console.log(this.child);
   this.addChild3();
   setTimeout(() =>this.goBack(),300); 
     
    }


addChild(){
  this.childService.addChild( this.child).subscribe(data=>{
    console.log(data)
   
    
  },
 error=> console.log(error));
}

goBack(): void {
  this.location.back();
}

getEmployee():void{

  this.id = this.route.snapshot.params['id'];
  this.employeeService.getEmployee(this.id).subscribe(data=>{this.employee=data 
    console.log(data)
    ;},
  error=>console.log(error));
  }

addChild3():void{
  this.id = this.route.snapshot.params['id'];
  
   
  this.childService.addEmployeesChild3( this.child,this.id).subscribe(data=>{
    console.log(data)
   
    
  },
 error=> console.log(error));
}    

}




