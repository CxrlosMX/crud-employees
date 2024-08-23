package com.lc.crud_employee.services;

import com.lc.crud_employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IServiceEmployee {

    /**
     *
     * @param employee
     * @return Employee
     */
    Employee saveOrUpdates (Employee employee);

    /**
     *
     * @param id
     * @return return optional of an employee
     */
    Optional<Employee> findById(Long id);

    /**
     * @return list of all employees
     */
    List<Employee> findAll();

    /**
     *
     * @param id
     */
    void deleteById(Long id);

}
