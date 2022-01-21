import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouteReuseStrategy } from '@angular/router';
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

  constructor(
    private vacationService:VacationService,
    private employeeService:EmployeeService,
    private route: ActivatedRoute,
    private router: Router,
    


  ) { }

  vacation:Vacation = new Vacation();
  employee: Employee= new Employee();
  id:number;
  vacations:Vacation[]=[];


  ngOnInit(): void {
    this.getAllVacations();
  }

  calculateDays(){
    this.addNewVacation();
    setTimeout(() => this.getAllVacations(),400 );
  
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
         
         goToEmployeesScreen(){
          const id = Number(this.route.snapshot.paramMap.get('id'));
          this.router.navigate(['employees', id]);
          
          }

  
        }
  


