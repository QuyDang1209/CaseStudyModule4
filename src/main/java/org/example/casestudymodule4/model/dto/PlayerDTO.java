package org.example.casestudymodule4.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.casestudymodule4.model.Performence;
import org.example.casestudymodule4.model.Status;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    private Long id;
    private String code;
    private String name;
    private String dob;
    private String address;
    private String position;

    private Performence per;
    private double height;
    private double weight;
    private double salary;
    private String ranking;
    private MultipartFile img;

    private Status status;
}
