package org.example.casestudymodule4.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoachDTO {

    private Long id;

    @NotBlank(message = "Code is mandatory")
    private String code;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Date of birth is mandatory")
    // You can add a pattern to validate the date format if needed, e.g. @Pattern(regexp="\\d{4}-\\d{2}-\\d{2}", message="Date of birth must be in the format yyyy-MM-dd")
    private String dob;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Min(value = 0, message = "Salary must be positive")
    private double salary;

    @NotNull(message = "Image is mandatory")
    private MultipartFile img;
}
