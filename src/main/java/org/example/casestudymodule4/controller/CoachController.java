package org.example.casestudymodule4.controller;

import jakarta.validation.Valid;
import org.example.casestudymodule4.model.Coach;
import org.example.casestudymodule4.model.dto.CoachDTO;
import org.example.casestudymodule4.service.ICoachService;
import org.example.casestudymodule4.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/coaches")
public class CoachController {
    @Autowired
    private ICoachService coachService;
    @Autowired
    private AppUtils appUtils;

    @GetMapping("")
    public ResponseEntity<List<Coach>> findAllCoaches(@RequestParam(value = "name", required = false) String name) {
        List<Coach> list;
        if (name != null) {
            list = coachService.findCoachByName(name);
        } else {
            list = (List<Coach>) coachService.findAll();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<Iterable<Coach>> findAllCoach() {
//        List<Coach> coaches = (List<Coach>) coachService.findAll();
//        if (coaches.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(coaches, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> findCoachById(@PathVariable Long id) {
        Optional<Coach> coachOptional = coachService.findById(id);
        if (!coachOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coachOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coach> saveCoach(@RequestBody Coach coach) {
        return new ResponseEntity<>(coachService.save(coach), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> edit(@PathVariable Long id, CoachDTO coachDTO){
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
    public ResponseEntity<Coach> deleteCoach(@PathVariable Long id) {
        Optional<Coach> coachOptional = coachService.findById(id);
        if (!coachOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coachService.remove(id);
        return new ResponseEntity<>(coachOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> saveUpload(@Valid @ModelAttribute CoachDTO coachDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            /*
            List<String> errorMessages = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(String.join(", ", errorMessages));

             */
            return appUtils.mapErrorToResponse(bindingResult);
        }
        coachService.saveCoachDTO(coachDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
        return ResponseEntity.ok("Coach created successfully");
    }
}
