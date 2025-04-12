package com.example.ali.Controller;

import com.example.ali.Service.EmployeeService;
import com.example.ali.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws Exception{
        Employee employeeSavedToDB = this.employeeService.addEmployee(employee);
        System.out.println("Saved employee: " + employeeSavedToDB);
        return new ResponseEntity<Employee>(employeeSavedToDB, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employee = this.employeeService.getAllEmployee();
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<Employee> updateUser(@RequestBody Employee emp , @PathVariable ("userId") Integer userId )
    {
        Employee emp1 = this.employeeService.updateEmployee(emp, userId);
        return ResponseEntity.ok(emp1);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> delete(@PathVariable ("userId") Integer userId )
    {
        this.employeeService.deleteUser(userId);
        return ResponseEntity.ok().body("User deleted Successfully.");
    }

}