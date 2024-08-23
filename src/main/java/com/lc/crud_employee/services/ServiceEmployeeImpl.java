package com.lc.crud_employee.services;

import com.lc.crud_employee.entity.Employee;
import com.lc.crud_employee.repository.IRepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmployeeImpl implements IServiceEmployee {

    @Autowired
    private IRepositoryEmployee repositoryEmployee;

    @Override
    public Employee saveOrUpdates(Employee employee) {
    return repositoryEmployee.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repositoryEmployee.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return repositoryEmployee.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repositoryEmployee.deleteById(id);
    }
}