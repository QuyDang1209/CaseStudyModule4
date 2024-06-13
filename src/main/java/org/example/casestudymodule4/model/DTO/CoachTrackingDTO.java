package org.example.casestudymodule4.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoachTrackingDTO {
    private Long id;
    private Long coach;
    private Long bonusweak1;
    private Long bonusweak2;
    private Long bonusweak3;
    private Long bonusweak4;
    private Integer month;
    private Integer year;
}
