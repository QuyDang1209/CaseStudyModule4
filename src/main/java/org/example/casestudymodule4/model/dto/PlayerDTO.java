package org.example.casestudymodule4.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.casestudymodule4.model.Performence;
import org.example.casestudymodule4.model.Status;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class PlayerDTO {
    private Long id;

    @NotBlank(message = "Code is mandatory")
    private String code;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Date of birth is mandatory")
    // You can add a pattern to validate the date format if needed
    private String dob;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Position is mandatory")
    private String position;

    private Performence per;

    @Min(value = 0, message = "Height must be positive")
    private double height;

    @Min(value = 0, message = "Weight must be positive")
    private double weight;

    @Min(value = 0, message = "Salary must be positive")
    private double salary;

    @NotBlank(message = "Ranking is mandatory")
    private String ranking;

    @NotNull(message = "Image is mandatory")
    private MultipartFile img;

    private Status status;
}
