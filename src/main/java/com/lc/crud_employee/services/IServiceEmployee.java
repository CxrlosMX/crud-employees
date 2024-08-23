package com.lc.crud_employee.services;

import com.lc.crud_employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IServiceEmployee {

    Employee saveOrUpdates (Employee employee);

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    void deleteById(Long id);

}
