package com.lc.crud_employee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * Table Employees going to be a table in the database
 * **/
@Entity(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

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
