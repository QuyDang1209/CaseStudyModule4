package org.example.casestudymodule4.model.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CoachDTO {

    private Long id;
    private String code;
    private String name;
    private String dob;
    private String address;
    private double salary;
    private MultipartFile img;

}
