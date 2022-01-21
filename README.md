# HR_program_SGT_JAVA2_January_2022

<br /> **HR program**

<br />_Authors and developers: Oxana Belyaeva, Kristīne Šķendere, Tatjana Sokolova_
<br />_January 21st, 2022_

<br />The code is for an application for HR department of any company. For now it works via web.
<br />This program will make company’s responsibility for all employees’ information, documentation, children, vacations and departments much more productive and transparent.

<br />**Run the code**
<br />To run the code you need MySQL, MySQL Workbench (or another tool), IntelliJ IDEA, web browser.
1)	Open IntelliJ IDEA
2)	Check database credentials in file application.properties and change them if it is necessary (in package HR_program_SGT_JAVA2_January_2022 -> src -> main -> resources)
3)	Create new Schema “employee” in MySQL Workbench
4)	Run “ApplicationToRun” class (in package HR_program_SGT_JAVA2_January_2022 -> src -> main -> java)
5)	Wait until you see in the console the message “Started ApplicationToRun in XXXXX seconds (JVM running for XXXXX)”.
6)	Then open in terminal frontend launching console (go to package HR_program_SGT_JAVA2_January_2022 -> src -> main -> frontend -> hr; right mouse click -> Open In -> Terminal)
7)	Then launch frontend by typing after (place of the code is situated)\HR_program_SGT_JAVA2_January_2022\src\main\frontend\hr> the command ng serve --o
8)	After you see the message “√ Compiled successfully.” just wait, the web will open automatically.

<br />**How to use**
<br />On http://localhost:4200/login you will see the login page. To get in, you need to enter username “user1” and password “user1”. Then press “Submit”.
<br />Welcome, HR manager! Now you see the navbar with four buttons: Home, Employees, Department, Employees children.

<br />**“Home” button**
<br />No matter on which page you are, by pressing “Home” you always will be redirected to the main page.

<br />**“Employees” button**
<br />Here you see three buttons: “All Employees”, “All Employees”, “Add Employee”.
<br />On this page you can check if employee already exists in the database. Just type full or part of one of the parameters: name or surname, or personal code, or department.

<br />**“All Employees” button**
<br />There you will automatically see the list of all employees (active and inactive).
<br />You can sort this list by name and surname.
<br />You can choose how many employees will be displayed on one page: 10, 15 or 20.
<br />By pressing on any of employees you will see full information about employee, see part _“Employee information”_.

<br />**“Active Employees”**
<br />There you will automatically see the list of active employees.
<br />You can sort this list by name and surname.
<br />You can choose how many employees will be displayed on one page: 10, 15 or 20.
<br />By pressing on any of employees you will see full information about employee, see part _“Employee information”_.

<br />**“Employee information”**
<br />You will see full information and possibility:

1) to upload the document (copy of id, certificates, photo etc.)
<br />Press “Browse”, select file from your local computer, press “Upload” and the file will be saved locally in the project (in package HR_program_SGT_JAVA2_January_2022 -> upload) and you will see it below in the list of files.
<br />If you press on the file name, it is possible to can save the file locally on your computer (in chosen by you folder) and open it.

2) to press “Children” button
<br />a)	There you will automatically see the list of children of the employee.
<br />You can choose how many children will be displayed on one page: 3, 6 or 9.

<br />b)	If there are children, you can:
- update child’s information (press “Update”, change necessary information, press “Submit” to save the changes or press “Go Back” to cancel the changes).
- delete the child from database; the system will ask you “Are you sure?” and then you can cancel your choice or confirm it.
<br />
<br />c)	You can add new child by pressing “Add Child” or go back to the information of employee by pressing “Go Back”.
<br />
<br />d)	If you pressed “Add Child”, you have to fill in the information (personal code, date of birth, First name and Last name), press “Submit” to save the new child’s information or press “Go Back” to cancel the changes.

3) to press “Vacation” button
<br />Here you can calculate the maximum of calculated vacation days since start work date, but not more than 20 days (according to Latvia’s laws).
<br />Press “Calculate” to see the result or press “Go Back” to return on “Employee information” page.

4) to press “Delete employee” button
<br />The system will ask you “Are you sure?” and then you can cancel your choice or confirm it.
<br />If employee has at least one child, you will not be able to delete the employee. After pressing “confirm” nothing will happen. In this case, you need to go to the “Children” button, delete all children first, and then delete the employee.

5) to press “Update employee” button
<br />Change necessary information, press “Submit” to save the changes or press “Go Back” to cancel the changes.

<br />**“Add Employee” button**
<br />You have to fill in the information (fourteen fields, some of them are mandatory), press “Submit” to save the new employee’s information or press “Go Back” to cancel the changes.
<br />After pressing “Submit” button, you will see the list of all employees (active and inactive).

<br />**“Department” button**
<br />There you will automatically see the list of all departments.
<br />You can choose how many departments will be displayed on one page: 5, 10 or 15.
<br />
<br />a)	If there are departments, you can:
- update department’s information (press “Update”, change necessary information, press “Submit” to save the changes or press “Go Back” to cancel the changes).
- delete the department from database; the system will ask you “Are you sure you want to delete department? It can be deleted only if it is empty.” and then you can cancel your choice or confirm it.
If department has at least one employee, you will not be able to delete the department. After pressing “confirm” nothing will happen. In this case, you need to go to the “Employees” -> “All Employees” and move employees to another department by “Update Employee” button in each employee.

<br />b)	You can add new department by pressing “Add Department”.
<br />If you pressed “Add Department”, you have to fill in the information (name and address), press “Submit” to save the new department’s information.

<br />**“Employees children” button**
<br />There you will automatically see the list of children of active and inactive employees.
<br />You can sort this list by age, by age in descending order, by surname of parent, or choose children with age less than 13 years.
<br />You can choose how many employees will be displayed on one page: 10, 15 or 20.

<br />**_Of course, this code is only the basic of big application.
<br />There are so many features to implement. 😊_**
