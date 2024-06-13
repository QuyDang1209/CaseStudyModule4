package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.Coach;
import org.example.casestudymodule4.model.DTO.CoachDTO;

import java.util.List;

public interface ICoachService extends IGenericService<Coach> {
    Coach saveCoachDTO(CoachDTO coachDTO);

    List<Coach> findCoachByName(String name);

}
