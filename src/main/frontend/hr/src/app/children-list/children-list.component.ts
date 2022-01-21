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
  age:number =13;
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

private sortChildrenByAge(){
  this.childService.sortChildrenByAge().subscribe(data=>{
    this.children = data;
    console.log(data);
  },
  error=> console.log(error));
 }

private sortChildrenByAgeDesc(){
  this.childService.sortChildrenByAgeDesc().subscribe(data=>{
    this.children = data;
    console.log(data);
  },
  error=> console.log(error));

}
private getChildrenByAgeLesThan13(){
  this.childService.getChildrenByAgeLesThan13(this.age).subscribe(data=>{
  this.children = data;
  console.log(data);
},
error=> console.log(error));

}

private orderChildernByParentsSurname(){
  this.childService.orderChildernByParentsSurname().subscribe(data=>{
    this.children = data;
    console.log(data);
  },
  error=> console.log(error));
  }

selectedOption(){
  switch(this.selected) {
    case "1":
       this.sortChildrenByAge();
       break;
    case "2":
      this.sortChildrenByAgeDesc();
       break;
    case "3":
      this.getChildrenByAgeLesThan13();
       break;
       case "4":
      this.orderChildernByParentsSurname();
       break;
  }
}
}
