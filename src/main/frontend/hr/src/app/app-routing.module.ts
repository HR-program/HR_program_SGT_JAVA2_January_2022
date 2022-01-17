import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActiveEmployeesListComponent } from './active-employees-list/active-employees-list.component';
import { AddChildComponent } from './add-child/add-child.component';
import { AddDepartmentComponent } from './add-department/add-department.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { ChildrenListComponent } from './children-list/children-list.component';
import { DepartmentListComponent } from './department-list/department-list.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployessChildernComponent } from './employess-childern/employess-childern.component';
import { LoginComponent } from './login/login.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { SearchEmloyeeComponent } from './search-emloyee/search-emloyee.component';
import { SearchListComponent } from './search-list/search-list.component';
import { UpdateChildComponent } from './update-child/update-child.component';
import { UpdateDepartmentComponent } from './update-department/update-department.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  {path:'employees',component: EmployeeListComponent},
   {path: 'employees/:id', component: EmployeeComponent },
  {path:'certificates', component:CertificatesComponent},
  {path:'update-employee/:id', component: UpdateEmployeeComponent},
  {path:'add-employee', component: AddEmployeeComponent},
  {path:'search-employees', component: SearchEmloyeeComponent},
  // {path:'', redirectTo: 'search-employees', pathMatch:'full'},
  {path:'login', component: LoginComponent},
  {path:'searched-employees', component:SearchListComponent},
  {path:'add-child/:id',component:AddChildComponent},
  {path:'departments',component:DepartmentListComponent},
  {path:'add-department',component:AddDepartmentComponent},
  {path:'update-department/:id',component:UpdateDepartmentComponent},
  {path:'children-list', component: ChildrenListComponent},
  {path:'employees-children/:id',component: EmployessChildernComponent},
  {path:'employees-active',component:ActiveEmployeesListComponent},
  {path:'',component:NavigationBarComponent},
  {path:'update-child/:id',component:UpdateChildComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
