package org.example.casestudymodule4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Table(name ="players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Code is mandatory")
    private String code;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Date of birth is mandatory")
    // Add a pattern if you want to validate the date format, e.g. "yyyy-MM-dd"
    private String dob;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Position is mandatory")
    private String position;
    @ManyToOne
    @JoinColumn(name = "performences_id")
    private Performence per;
    @Min(value = 0, message = "Height must be positive")
    private double height;
    @Min(value = 0, message = "Weight must be positive")
    private double weight;
    @Min(value = 0, message = "Salary must be positive")
    private double salary;
    @NotBlank(message = "Ranking is mandatory")
    private String ranking;
    @NotBlank(message = "Image URL is mandatory")
    private String img;
    @ManyToOne
    @JoinColumn(name ="status_id")
    private Status status;

}
