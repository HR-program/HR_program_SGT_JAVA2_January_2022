import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Child } from '../child';
import { ChildService } from '../child.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Location } from '@angular/common';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';

@Component({
  selector: 'app-update-child',
  templateUrl: './update-child.component.html',
  styleUrls: ['./update-child.component.css']
})
export class UpdateChildComponent implements OnInit {

  child: Child = new Child();
id = this.route.snapshot.params['id'];
  employee: Employee = new Employee;
  colorTheme = 'theme-default'
  bsConfig?: Partial<BsDatepickerConfig>;
   applyTheme(){
     this.bsConfig =  { containerClass: this.colorTheme,dateInputFormat: 'DD/MM/YYYY' }
   }

  constructor(
    private childService: ChildService,
    private location: Location,
       private route: ActivatedRoute,
    private employeeService: EmployeeService,
      ) { }


    ngOnInit(): void {
this.getChild()
this.applyTheme();
    }

getChild(){
  this.childService.getChildById(this.id).subscribe(data=>{
    this.child = data;
    console.log(data)
  },
error=> console.log(error));
}

updateChild(){
  this.childService.updateChild(this.id, this.child).subscribe(data=>{
    console.log(data)
  },
  error=> console.log(error));
  }

    onSubmit(){
      console.log(this.child);
    this.updateChild();
     setTimeout(() =>this.goBack(),300);
      }

  goBack(): void {
    this.location.back();
  }
  }
