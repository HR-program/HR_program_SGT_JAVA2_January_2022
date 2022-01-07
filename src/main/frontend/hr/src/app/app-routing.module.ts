import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginComponent } from './login/login.component';
import { SearchEmloyeeComponent } from './search-emloyee/search-emloyee.component';
import { SearchListComponent } from './search-list/search-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  {path:'employees',component: EmployeeListComponent},
   {path: 'employees/:id', component: EmployeeComponent },
  {path:'certificates', component:CertificatesComponent},
  {path:'update-employee/:id', component: UpdateEmployeeComponent},
  {path:'add-employee', component: AddEmployeeComponent},
  {path:'search-employees', component: SearchEmloyeeComponent},
  {path:'', redirectTo: 'search-employees', pathMatch:'full'},
  {path:'login', component: LoginComponent},
  {path:'searched-employees', component:SearchListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
