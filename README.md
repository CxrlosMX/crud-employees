# CRUD Employees - Java Spring Boot

Este proyecto es una API RESTful desarrollada en Java utilizando el framework Spring Boot. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una entidad "Empleado". La base de datos utilizada en este proyecto es **MySQL**.

## Requisitos

- **Java 17** o superior
- **Maven**
- **MySQL Server**

## Configuración del Proyecto

1. **Clonar el Repositorio**

   ```bash
   git clone https://github.com/tuusuario/crud-employees.git
   cd crud-employees

## Clase `Employee`

La clase `Employee` es una entidad JPA que representa a un empleado en la base de datos. A continuación se muestra el código de la clase:

```
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hiringDate;
}
```

# Endpoints de la API

## Get All 
Obtiene todos los registros de la base de datos
![Image getAll](https://github.com/yourusername/yourrepository/blob/main/path/to/image.png)


