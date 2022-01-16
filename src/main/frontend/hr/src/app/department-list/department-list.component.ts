import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Department } from '../department';
import { DepartmentService } from '../department.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})
export class DepartmentListComponent implements OnInit {

  

  constructor(private departmentService:DepartmentService,
    private route: ActivatedRoute,
    private router:Router,
  private location: Location,) { }
department: Department = new Department();
  departments:Department[]=[];
  totalLength: any;
  page: any=1;
  pageSizes = [5,10,15];
  // totalElements =0;
  // pageSize:number=3;
  noOfRows =5;

  ngOnInit(): void {
    document.getElementById('goToLastPage').hidden = true;
    this.getDepatments();
  }
  getDepatments(){
    this.departmentService.getDepartmentsList().subscribe(data=>{
      this.departments=data;
      this.totalLength=data.length;
console.log(data);
    })
  
}


deleteDepartement(id: number):void{
  // const id = Number(this.route.snapshot.paramMap.get('id'));
  this.departmentService.deleteDepartment(id).subscribe(data=>{console.log(id);
    this.getDepatments();},
  error => {
    console.log(error);
  }
    )
}
goToUpdatePage(id:number){
  this.router.navigate(['update-department',id]);
}
goBack(): void {
  this.location.back();
   
}
}
