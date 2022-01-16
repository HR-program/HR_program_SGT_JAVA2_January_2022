import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppRoutingModule } from '../app-routing.module';
import { Child } from '../child';
import { ChildService } from '../child.service';
import { Employee } from '../employee';
import { Location } from '@angular/common';

@Component({
  selector: 'app-employess-childern',
  templateUrl: './employess-childern.component.html',
  styleUrls: ['./employess-childern.component.css']
})
export class EmployessChildernComponent implements OnInit {
  employee:Employee = new Employee();

id: number;
  children: Child[] =[];
  totalLength: any;
  page: any=1;
  pageSizes = [3, 6, 9];
  totalElements =0;
  pageSize:number=3;
  noOfRows =3;
  name=this.employee.name;

  constructor(private childService: ChildService,
    private route: ActivatedRoute,
    private router:Router,
    private location:Location) { }

  ngOnInit(): void {

    this.getEmplyoeesChildren();
    document.getElementById('goToLastPage').hidden = true;

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

  goToUpdateChildPage(){

  }

  deleteChild(){}

  }


  