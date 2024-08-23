package com.lc.crud_employee.controller;

import com.lc.crud_employee.entity.Employee;
import com.lc.crud_employee.services.ServiceEmployeeImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private ServiceEmployeeImpl serviceEmployee;

    @GetMapping("/get-all")
    public List<Employee> getAll() {
        return serviceEmployee.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Optional<Employee> empleado = serviceEmployee.findById(id);
        return empleado.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee nuevoEmpleado = serviceEmployee.saveOrUpdates(employee);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        Optional<Employee> exist = serviceEmployee.findById(id);
        if (exist.isPresent()) {
            Employee employee1=exist.get();
            employee1.setName(employee.getName());
            employee1.setSalary(employee.getSalary());
            employee1.setPosition(employee.getPosition());
            employee1.setHiringDate(employee.getHiringDate());
           serviceEmployee.saveOrUpdates(employee1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        Optional<Employee> employeeById = serviceEmployee.findById(id);
        if (employeeById.isPresent()) {
            serviceEmployee.deleteById(id);
            return new ResponseEntity<>(employeeById.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
