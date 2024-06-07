package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.Coach;
import org.example.casestudymodule4.model.dto.CoachDTO;

public interface ICoachService extends IGenericService<Coach> {
    Coach saveCoachDTO(CoachDTO coachDTO);
}
