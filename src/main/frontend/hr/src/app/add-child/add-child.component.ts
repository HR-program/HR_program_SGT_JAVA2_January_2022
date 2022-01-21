import { Component, OnInit } from '@angular/core';
import { Child } from '../child';
import { ChildService } from '../child.service';
import { Location } from '@angular/common';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';


@Component({
  selector: 'app-add-child',
  templateUrl: './add-child.component.html',
  styleUrls: ['./add-child.component.css']
})
export class AddChildComponent implements OnInit {

child: Child = new Child();
children: Child[]=[];
id = this.route.snapshot.params['id'];
  employee: Employee = new Employee;
  colorTheme = 'theme-default'
  bsValue = new Date();

 bsConfig?: Partial<BsDatepickerConfig>;

  applyTheme(){
    this.bsConfig =  { containerClass: this.colorTheme,dateInputFormat: 'DD/MM/YYYY' }
  }

  constructor(private childService: ChildService,
    private location: Location,
       private route: ActivatedRoute,
    private employeeService: EmployeeService,
        ) { }

  ngOnInit(): void {
    this.applyTheme();
  }
  onSubmit(){
   console.log(this.child);
   this.addChild3();
   this.goBack();
   setTimeout(() =>this.getChildren(),500 );
   setTimeout(() => document.getElementById('goToLastPage').click(),400 )
    }

    getChildren(){
      this.childService.getChildrenList().subscribe(data=>{
        this.children = data;
        console.log(data)},)}

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
