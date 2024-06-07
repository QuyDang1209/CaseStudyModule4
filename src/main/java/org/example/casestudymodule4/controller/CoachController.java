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
        List<Coach> coaches = (List<Coach>) coachService.findAll();
        if (coaches.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(coaches, HttpStatus.OK);
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
    public ResponseEntity<Coach> saveCustomer(@RequestBody Coach coach) {
        return new ResponseEntity<>(coachService.save(coach), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCustomer(@PathVariable Long id, @RequestBody Coach coach) {
        Optional<Coach> coachOptional = coachService.findById(id);
        if (!coachOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coach.setId(coachOptional.get().getId());
        return new ResponseEntity<>(coachService.save(coach), HttpStatus.OK);
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