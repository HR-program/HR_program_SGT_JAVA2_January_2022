import { Department } from "./department";

export class Employee {
    id: number | undefined;
    name: string | undefined;
   workStartDate: any;
   workEndDate: any;
    surname: string|undefined;
    gender:any;
    dateOfBirth:any;
    personalCode: string|undefined;
    idDocumentNumber: string|undefined;
    idDocumentExpiryDate:any;
    phoneNumber: string|undefined;
    email: string|undefined;
    address: string|undefined;
    education: string|undefined;
    department:Department;
    certificate: string|undefined ;
    doesEmployeeHaveChild: boolean|undefined;
    employeeActive: boolean|undefined;
}
