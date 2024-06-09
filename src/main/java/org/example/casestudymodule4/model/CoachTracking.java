package org.example.casestudymodule4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coach_trackings")
public class CoachTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "coachs_id")
    private Coach coach;
    private Long bonusweak1;
    private Long bonusweak2;
    private Long bonusweak3;
    private Long bonusweak4;
    private Integer month;
    private Integer year;
    private double totalsalary;

}
