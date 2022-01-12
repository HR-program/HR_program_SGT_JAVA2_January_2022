package lv.hr.program.model;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table (name = "employees_children")
public class EmployeesChildren {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeesChildren_id")
   private long Id;
    @Column(name = "employees_id")
    private long employeesId;
    @Column(name = "employees_name")
    private String employeesName;
    @Column(name = "employees_surname")
    private String employeesSurname;
    @Column(name = "child_id")
    private long childId;

    @Column(name = "child_personal_code")
    private String childPersonalCode;

    @Column(name = "child_date_of_birth")
    private Date childDateOfBirth;

    @Column(name = "child_name")
    private String childName;

    @Column(name = "child_surname")
    private String childSurname;

 public EmployeesChildren() {
 }

 public EmployeesChildren(long id, long employeesId, String employeesName, String employeesSurname, long childId, String childPersonalCode, Date childDateOfBirth, String childName, String childSurname) {
  Id = id;
  this.employeesId = employeesId;
  this.employeesName = employeesName;
  this.employeesSurname = employeesSurname;
  this.childId = childId;
  this.childPersonalCode = childPersonalCode;
  this.childDateOfBirth = childDateOfBirth;
  this.childName = childName;
  this.childSurname = childSurname;
 }

 public long getId() {
  return Id;
 }

 public void setId(long id) {
  Id = id;
 }

 public long getEmployeesId() {
  return employeesId;
 }

 public void setEmployeesId(long employeesId) {
  this.employeesId = employeesId;
 }

 public String getEmployeesName() {
  return employeesName;
 }

 public void setEmployeesName(String employeesName) {
  this.employeesName = employeesName;
 }

 public String getEmployeesSurname() {
  return employeesSurname;
 }

 public void setEmployeesSurname(String employeesSurname) {
  this.employeesSurname = employeesSurname;
 }

 public long getChildId() {
  return childId;
 }

 public void setChildId(long childId) {
  this.childId = childId;
 }

 public String getChildPersonalCode() {
  return childPersonalCode;
 }

 public void setChildPersonalCode(String childPersonalCode) {
  this.childPersonalCode = childPersonalCode;
 }

 public Date getChildDateOfBirth() {
  return childDateOfBirth;
 }

 public void setChildDateOfBirth(Date childDateOfBirth) {
  this.childDateOfBirth = childDateOfBirth;
 }

 public String getChildName() {
  return childName;
 }

 public void setChildName(String childName) {
  this.childName = childName;
 }

 public String getChildSurname() {
  return childSurname;
 }

 public void setChildSurname(String childSurname) {
  this.childSurname = childSurname;
 }
}
