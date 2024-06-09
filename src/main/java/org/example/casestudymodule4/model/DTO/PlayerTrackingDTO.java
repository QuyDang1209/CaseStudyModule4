package org.example.casestudymodule4.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlayerTrackingDTO {
    private Long id;
    private Long player;
    private Long weak1;
    private Long weak2;
    private Long weak3;
    private Long weak4;
    private Integer month;
    private Integer year;
    private double bonus;
    private Long performence;
}
