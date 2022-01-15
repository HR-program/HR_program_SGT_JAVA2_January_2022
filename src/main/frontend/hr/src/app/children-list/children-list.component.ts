import { Component, OnInit } from '@angular/core';
import { Child } from '../child';
import { ChildService } from '../child.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-children-list',
  templateUrl: './children-list.component.html',
  styleUrls: ['./children-list.component.css']
})
export class ChildrenListComponent implements OnInit {
  selected: string ="--Choose option--";
  children: Child[] =[];
  totalLength: any;
  page: any=1;
  pageSizes = [10,15,20];
  totalElements =0;
  // pageSize:number=3;
  noOfRows =10;
  constructor(private childService: ChildService,
    private location: Location,) { }

  ngOnInit(): void {
    this.getChildren();
    document.getElementById('goToLastPage').hidden = true;
    
  }
private getChildren(){
  this.childService.getChildrenList().subscribe(data=>
    {this.children = data;
      this.totalLength=data.length;
    console.log(data)},)
}

selectedOption(){

  switch(this.selected) {
    case "1":
       // if modo 1 is selected do something.
       break;
    case "4":
     
       break;
    case "5":
       
       break;

  }
}

goBack(): void {
  this.location.back();
   
}
}


// private getEmployees(){
//   this.employeeService.getEmployeesList().subscribe(data =>{
//     this.employees = data;
//     this.totalLength=data.length;
//     console.log (data)
//            })
