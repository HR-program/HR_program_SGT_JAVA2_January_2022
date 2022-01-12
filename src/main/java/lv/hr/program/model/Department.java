package lv.hr.program.model;

import ch.qos.logback.core.BasicStatusManager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "department")
public class Department<cascade> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "department_address")
    private String address;

    @OneToMany
//            (mappedBy = "department")
    private List<Employee> employeeArrayList = new ArrayList<>();


    public Department() {
    }

    public Department( String name, String address) {

        this.name = name;
        this.address = address;
    }

    public Department(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

//    method to add employee to employeeArray

//    public void addEmployee(Employee employee) {
//        employeeArrayList.add(employee);
//    }






//    public List<Employee> getEmployeeArrayList() {
//        return employeeArrayList;
//    }
//
//    public void setEmployeeArrayList(List<Employee> employeeArrayList) {
//        this.employeeArrayList = employeeArrayList;
//    }


