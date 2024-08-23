package com.lc.crud_employee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Table Employees going to be a table in the database
 * **/
@Entity(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

/**
 * - La entidad "Empleado" debe tener los siguientes campos: `id`, `nombre`, `puesto`, `salario`, `fechaContratacion`.
 *
 * - Implementar validaciones básicas (por ejemplo, que el `nombre` no esté vacío y que el `salario` sea un número positivo, etc). Las validaciones que consideres necesarias para que no ocurran errores inesperados.
 *
 * - Se tiene libertad para usar MongoDB, Oracle o MySQL para la implementación de la base de datos
 *
 * **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "The position is required")
    private String position;

    @Min(value = 0L, message = "The value must be positive")
    private Double salary;

    @PastOrPresent(message = "The date needs to be past or present, not future")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date hiringDate;

}
