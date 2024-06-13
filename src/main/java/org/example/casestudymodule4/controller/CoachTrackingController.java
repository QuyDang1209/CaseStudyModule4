package org.example.casestudymodule4.controller;

import org.example.casestudymodule4.model.CoachTracking;
import org.example.casestudymodule4.model.PlayerTracking;
import org.example.casestudymodule4.model.dto.CoachTrackingDTO;
import org.example.casestudymodule4.model.dto.PlayerTrackingDTO;
import org.example.casestudymodule4.service.ICoachTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/coach_tracking")
public class CoachTrackingController {
    @Autowired
    private ICoachTrackingService coachTrackingService;
    @GetMapping
    public ResponseEntity<List<CoachTracking>> findAll(){
        return new ResponseEntity<>(coachTrackingService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<CoachTracking>> save(@RequestBody List<CoachTrackingDTO> CoachTrackingDTO){
        coachTrackingService.saveCoachTrackingDTO(CoachTrackingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED) ;
    }
    @GetMapping("/{month}/{year}")
    public ResponseEntity<List<CoachTracking>> findAll(@PathVariable Integer month, @PathVariable Integer year) {
        return new ResponseEntity<>(coachTrackingService.findAllByMonthAndYear(month,year), HttpStatus.OK);
    }

    @GetMapping("/{id}/{month}/{year}")
    public ResponseEntity<List<CoachTracking>> findAllCoachTracking(@PathVariable Long id, @PathVariable Integer month, @PathVariable Integer year) {
        return new ResponseEntity<>(coachTrackingService.findAllCoachTrackingByIdAndMonthAndYear(id, month, year), HttpStatus.OK);
    }
}
