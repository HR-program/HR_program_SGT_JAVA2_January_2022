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
import { SearchEmloyeeComponent } from './search-emloyee/search-emloyee.component';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClientModule } from '@angular/common/http'
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { SearchListComponent } from './search-list/search-list.component';
import { VacationComponent } from './vacation/vacation.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    EmployeeListComponent,
    AddEmployeeComponent,
    UpdateEmployeeComponent,
    CertificatesComponent,
    SearchEmloyeeComponent,
    SearchListComponent,
    VacationComponent,

  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgxPaginationModule,
    HttpClientModule,
    routing,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger', // set defaults here
    }),
  ],
  providers: [],
  declarations: [
          AppComponent,
          HomeComponent,
          LoginComponent
      ],
  bootstrap: [AppComponent]
})
export class AppModule { }
