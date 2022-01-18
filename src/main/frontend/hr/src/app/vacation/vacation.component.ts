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

  constructor(
    private vacationService:VacationService,
    private employeeService:EmployeeService,
    private route:ActivatedRoute) { }

  ngOnInit(): void {}

    // addVacationTable(id:number, vacation){
    //   this.
    // }

    // addVacationTable(vacation:Vacation, id:number): Observable<Object>{
    //   return this.httpClient.post(`${this.baseURL}/${id}`, vacation);
    // }

    onSubmit(){
      this.getEmployee();
      this.addNewVacation();
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
      }
