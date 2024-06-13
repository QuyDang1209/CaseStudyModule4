package org.example.casestudymodule4.controller;

import org.example.casestudymodule4.model.PlayerTracking;
import org.example.casestudymodule4.model.DTO.PlayerTrackingDTO;
import org.example.casestudymodule4.service.IPlayerTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/playertracking")
public class PlayerTrackingController {
    @Autowired
    IPlayerTrackingService playerTrackingService;
    @GetMapping("/{month}/{year}")
    public ResponseEntity<List<PlayerTracking>> findAll(@PathVariable Integer month, @PathVariable Integer year) {
        return new ResponseEntity<>(playerTrackingService.findAllByMonthAndYear(month,year), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PlayerTracking>> finAllList(){
        return new ResponseEntity<>(playerTrackingService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<PlayerTracking>> save(@RequestBody List<PlayerTrackingDTO> playerTrackingDTO){
        playerTrackingService.savePlayerTrackingDTO(playerTrackingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED) ;
    }


}
