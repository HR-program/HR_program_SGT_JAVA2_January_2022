import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppRoutingModule } from '../app-routing.module';
import { Child } from '../child';
import { ChildService } from '../child.service';
import { Employee } from '../employee';
import { Location } from '@angular/common';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employess-childern',
  templateUrl: './employess-childern.component.html',
  styleUrls: ['./employess-childern.component.css']
})

export class EmployessChildernComponent implements OnInit {
  employee:Employee = new Employee();
employeeName:string;
id: number;
child: Child =new Child();
  children: Child[] =[];
  totalLength: any;
  page: any=1;
  pageSizes = [3, 6, 9];
  totalElements =0;
  pageSize:number=3;
  noOfRows =3;
  name=this.employee.name;
  popoverTitle = 'Delete';
  popoverMessage = 'Are you sure';
  confirmClicked = false;
  cancelClicked = false;
  parent:string;

  constructor(private childService: ChildService,
    private route: ActivatedRoute,
    private router:Router,
    private location:Location,
    private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getEmplyoeesChildren();
    document.getElementById('goToLastPage').hidden = true;
    this.id = this.route.snapshot.params['id'];
  this.parent = this.employee.name;
    }

    getEmplyoeesChildren(){
      this.id = this.route.snapshot.params['id'];
this.childService.getChildrenByEmployessID(this.id).subscribe(data=>{
  this.children = data
  console.log(data);
},)
  }

  goToAddChildrenPage(id:number){
    this.id = this.route.snapshot.params['id'];
    this.router.navigate (['add-child',this.id]);
  }

  goBack(): void {
    this.location.back();
  }

  deleteChild(id: number){
    this.childService.deleteChild(id).subscribe(data=>{
      console.log(data);
      console.log(id);
      this.getEmplyoeesChildren();
  }, error => {console.log(error);})
  }
}
