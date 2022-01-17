import { Component, OnInit } from '@angular/core';
import { DataSharingService } from '../data-sharing.service';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';



@Component({
  selector: 'app-search-list',
  templateUrl: './search-list.component.html',
  styleUrls: ['./search-list.component.css']
})
export class SearchListComponent implements OnInit {
  selected: string ="--Choose option--";
  employees: Employee[] =[];
  totalLength: any;
  page: any=1;
  pageSizes = [3, 6, 9];
  totalElements =0;
  pageSize:number=3;
  noOfRows =3;

  constructor(private employeeService: EmployeeService,
    private dataSharingService: DataSharingService
   ) { }

  ngOnInit(): void {
    // this.getEmployees();
   this.dataSharingService.passingArray$
   .subscribe(
     message=>{this.employees=message
   
    }
       )
console.log(this.employees)
    document.getElementById('goToLastPage').hidden = true;}

    private getEmployees(){
      this.employeeService.getEmployeesList().subscribe(data =>{
        this.employees = data;
        this.totalLength=data.length;
        console.log (data)
               })
    }
    sortByName():void{
      this.employeeService.sortByName().subscribe
      (data =>{
        this.employees = data;
        console.log (data);
      })}

    sortBySurname():void{
      this.employeeService.sortBySurname().subscribe
      (data =>{
        this.employees = data;
        console.log (data);
      })}

   selectedOption(){

      switch(this.selected) {
        case "1":
           // if modo 1 is selected do something.
           break;
        case "4":
           this.sortBySurname();
           break;
        case "5":
           this.sortByName();
           break;
      }
  }
}
