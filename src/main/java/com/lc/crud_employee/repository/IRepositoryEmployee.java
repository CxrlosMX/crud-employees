package com.lc.crud_employee.repository;

import com.lc.crud_employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEmployee extends JpaRepository<Employee, Long> {

}
