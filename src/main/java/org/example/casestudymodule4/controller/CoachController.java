package org.example.casestudymodule4.controller;

import org.example.casestudymodule4.model.Coach;
import org.example.casestudymodule4.model.dto.CoachDTO;
import org.example.casestudymodule4.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/coaches")
public class CoachController {
    @Autowired
    private ICoachService coachService;

    @GetMapping
    public ResponseEntity<Iterable<Coach>> findAllCoach() {

        return new ResponseEntity<>(coachService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> findCoachById(@PathVariable Long id) {
        Optional<Coach> coachOptional = coachService.findById(id);
        if (!coachOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coachOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coach> saveCustomer( CoachDTO coachDTO) {
        coachService.saveCoachDTO(coachDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    private ResponseEntity<?> edit(@PathVariable Long id,   CoachDTO coachDTO){
        coachDTO.setId(id);
        Optional<Coach> coachOptional = Optional.ofNullable(coachService.findById(id).get());
        if (!coachOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            coachDTO.setId(id);
            coachService.saveCoachDTO(coachDTO);
            return new ResponseEntity<>(coachOptional.get(), HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coach> deleteCustomer(@PathVariable Long id) {
        Optional<Coach> coachOptional = coachService.findById(id);
        if (!coachOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coachService.remove(id);
        return new ResponseEntity<>(coachOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> saveUpload(CoachDTO coachDTO) {
        coachService.saveCoachDTO(coachDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
