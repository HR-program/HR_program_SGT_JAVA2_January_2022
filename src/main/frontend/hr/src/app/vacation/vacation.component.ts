import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Vacation } from '../vacation';
import { VacationService } from '../vacation.service';

@Component({
  selector: 'app-vacation',
  templateUrl: './vacation.component.html',
  styleUrls: ['./vacation.component.css']
})
export class VacationComponent implements OnInit {
  vacation:Vacation = new Vacation();
  employee: Employee= new Employee();
  id:number;
  vacations:Vacation[]=[];
  totalLength: any;
  page: any=1;
  pageSizes = [3, 6, 9];
  totalElements =0;
  pageSize:number=3;
  noOfRows =3;
  constructor(
    private vacationService:VacationService,
    private employeeService:EmployeeService,
    private route:ActivatedRoute,
    private location: Location) { }

  ngOnInit(): void {
    this.getEmployee();
      
      
  }



    onSubmit(){
      this.addNewVacation();
      this.getAllVacations();
    }

    getEmployee():void{
      
  this.id = this.route.snapshot.params['id'];
      this.employeeService.getEmployee(this.id).subscribe(data=>{
        this.employee=data;
        console.log(data);
        ;},
        error=>console.log(error));
        }

      addNewVacation(){
        this.id = this.route.snapshot.params['id'];
        this.vacationService.addVacationTable(this.vacation, this.id).subscribe(data =>{
          console.log(data);
                   
        },
        error=> console.log(error));
       }    

       getAllVacations(){
        this.id = this.route.snapshot.params['id'];
        this.vacationService.getVacationTable(this.id).subscribe(data=>{
          this.vacations=data;
          console.log(data);
                   
        },
        error=> console.log(error));
       }    


      }