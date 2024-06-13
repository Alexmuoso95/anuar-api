package com.anuar.my_first_app.controller;

import com.anuar.my_first_app.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl {

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("success");
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(addEmployees(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST , path = "/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
       return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    private List<Employee> addEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("Juan Pérez");
        employee1.setPosition("Developer");
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Carlos García");
        employee2.setPosition("Developer");
        employees.add(employee2);

        Employee employee3 = new Employee();
        employee3.setId(3L);
        employee3.setName("Luis Martínez");
        employee3.setPosition("Developer");
        employees.add(employee3);

        Employee employee4 = new Employee();
        employee4.setId(4L);
        employee4.setName("José Rodríguez");
        employee4.setPosition("Developer");
        employees.add(employee4);

        Employee employee5 = new Employee();
        employee5.setId(5L);
        employee5.setName("Miguel Sánchez");
        employee5.setPosition("Developer");
        employees.add(employee5);

        Employee employee6 = new Employee();
        employee6.setId(6L);
        employee6.setName("Pedro López");
        employee6.setPosition("Developer");
        employees.add(employee6);

        Employee employee7 = new Employee();
        employee7.setId(7L);
        employee7.setName("Antonio Fernández");
        employee7.setPosition("Developer");
        employees.add(employee7);

        Employee employee8 = new Employee();
        employee8.setId(8L);
        employee8.setName("Anuar");
        employee8.setPosition("Almost Developer");
        employees.add(employee8);
        return employees;
    }
}