package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.CoachTracking;
import org.example.casestudymodule4.model.PlayerTracking;
import org.example.casestudymodule4.model.dto.CoachTrackingDTO;
import org.example.casestudymodule4.model.dto.PlayerTrackingDTO;
import org.example.casestudymodule4.repository.ICoachTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoachTrackingService implements ICoachTrackingService {
    @Autowired
    private ICoachTrackingRepository coachTrackingRepository;

    @Autowired
    private ICoachService coachService;

    @Override
    public List<CoachTracking> findAll() {
        return coachTrackingRepository.findAll();
    }

    @Override
    public List<CoachTracking> findAllByMonthAndYear(Integer month, Integer year) {
        return coachTrackingRepository.findCoachTrackingByMonthAndYear(month, year);
    }

    @Override
    public CoachTracking findByid(Long id) {
        return coachTrackingRepository.findById(id).get();
    }

    @Override
    public void save(CoachTracking coachTracking) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<CoachTracking> saveCoachTrackingDTO(List<CoachTrackingDTO> coachTrackingDTO) {
        List<CoachTracking> coachTrackingList = coachTrackingRepository.findAll();
        for (CoachTrackingDTO c : coachTrackingDTO) {
            CoachTracking coachTracking = new CoachTracking();
            coachTracking.setCoach(coachService.findById(c.getCoach()).get());
            coachTracking.setBonusweak1(c.getBonusweak1());
            coachTracking.setBonusweak2(c.getBonusweak2());
            coachTracking.setBonusweak3(c.getBonusweak3());
            coachTracking.setBonusweak4(c.getBonusweak4());
            coachTracking.setMonth(c.getMonth());
            coachTracking.setYear(c.getYear());
            coachTracking.setTotalsalary(c.getBonusweak1() + c.getBonusweak2() + c.getBonusweak3() + c.getBonusweak4() + coachService.findById(c.getCoach()).get().getSalary());
            coachTrackingRepository.save(coachTracking);
            coachTrackingList.add(coachTracking);
        }
        return coachTrackingList;
    }

    @Override
    public List<CoachTracking> findAllCoachTrackingByIdAndMonthAndYear(Long id, Integer month, Integer year) {
        List<CoachTracking> coachTrackingList = new ArrayList<>();
        if (month == 1) {
            coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), month, year));
            coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), 12, year - 1));
            coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), 11, year - 1));
        } else {
            if (month == 2) {
                coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), month, year));
                coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), month - 1, year));
                coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), 12, year - 1));
            } else {
                coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), month, year));
                coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), month - 1, year));
                coachTrackingList.add(coachTrackingRepository.findAllCoachTrackingByCoachAndMonthAndYear(coachService.findById(id).get(), month - 2, year));
            }
        }
        return coachTrackingList;
    }
}