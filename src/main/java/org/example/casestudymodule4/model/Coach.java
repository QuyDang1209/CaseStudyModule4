package org.example.casestudymodule4.model;

import jakarta.persistence.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.*;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="coachs")
public class Coach{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Code is mandatory")
    private String code;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Date of birth is mandatory")
    // Add a pattern if you want to validate the date format, e.g., "yyyy-MM-dd"
    private String dob;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @Min(value = 0, message = "Salary must be positive")
    private double salary;
    @NotBlank(message = "Image URL is mandatory")
    private String img;
}
