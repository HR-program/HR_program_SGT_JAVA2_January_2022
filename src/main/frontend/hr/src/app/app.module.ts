import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { CertificatesComponent } from './certificates/certificates.component';
import {ReactiveFormsModule} from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { SearchListComponent } from './search-list/search-list.component';
import { AddChildComponent } from './add-child/add-child.component';
import { DepartmentListComponent } from './department-list/department-list.component';
import { AddDepartmentComponent } from './add-department/add-department.component';
import { UpdateDepartmentComponent } from './update-department/update-department.component';
import { ChildrenListComponent } from './children-list/children-list.component';
import { EmployessChildernComponent } from './employess-childern/employess-childern.component';
import { ActiveEmployeesListComponent } from './active-employees-list/active-employees-list.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { UpdateChildComponent } from './update-child/update-child.component';
import { BsDatepickerModule, BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchEmployeeComponent } from './search-employee/search-employee.component';
import { VacationComponent } from './vacation/vacation.component';
import { UploadFilesComponent } from './components/upload-files/upload-files.component';
import { RequestInterceptor } from './request.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    EmployeeListComponent,
    AddEmployeeComponent,
    UpdateEmployeeComponent,
    CertificatesComponent,
    SearchEmployeeComponent,
    SearchListComponent,
    AddChildComponent,
     DepartmentListComponent,
    AddDepartmentComponent,
    UpdateDepartmentComponent,
    ChildrenListComponent,
    EmployessChildernComponent,
    ActiveEmployeesListComponent,
    NavigationBarComponent,
    UpdateChildComponent,
    VacationComponent,
    UploadFilesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgxPaginationModule,
    HttpClientModule,
    ConfirmationPopoverModule.forRoot({
    }),
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true }],
  bootstrap: [AppComponent]
})

export class AppModule { }
