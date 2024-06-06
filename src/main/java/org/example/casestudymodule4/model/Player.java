package org.example.casestudymodule4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
    private String code;
    private String name;
    private String dob;
    private String address;
    private String position;
    @ManyToOne
    @JoinColumn(name = "performences_id")
    private Performence per;
    private double height;
    private double weight;
    private double salary;
    private String ranking;
    private String img;
    @ManyToOne
    @JoinColumn(name ="status_id")
    private Status status;

}
