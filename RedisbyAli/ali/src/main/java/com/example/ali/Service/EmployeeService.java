package com.example.ali.Service;

import com.example.ali.Repo.EmployeeRepository;
import com.example.ali.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @CachePut(value = "employee", key = "#employee.id")
    public Employee addEmployee(Employee employee) throws Exception {
        Employee employeeSavedToDB = this.employeeRepository.save(employee);
        return employeeSavedToDB;
    }
    @Cacheable(value = "employees", key = "'allEmployees'")
    public  List<Employee> getAllEmployee(){
        List<Employee> employee = this.employeeRepository.findAll();
        return  employee;
    }

    @Cacheable(value = "employees", key = "#userId")
    public Employee updateEmployee(Employee employee , Integer userId){
        Employee employee1 = this.employeeRepository.findById(userId).orElseThrow();
        employee1.setId(employee.getId());
        employee1.setName(employee.getName());
      this.employeeRepository.save(employee1);
        return employee1;
    }

    @CacheEvict(value = "employees", key = "#userId")
    public void  deleteUser(Integer userId){
        Employee employee = this.employeeRepository.findById(userId).orElseThrow();
        this.employeeRepository.delete(employee);
    }

}
