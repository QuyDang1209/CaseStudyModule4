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
@Table(name = "player_trackings")
public class PlayerTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="players_id")
    private Player player;
    private Long weak1;
    private Long weak2;
    private Long weak3;
    private Long weak4;
    private Integer month;
    private Integer year;
    private double bonus;

    private Double totalSalary;
    @ManyToOne
    @JoinColumn(name = "performences_id")
    private Performence performence;

}
