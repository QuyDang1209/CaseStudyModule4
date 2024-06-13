package org.example.casestudymodule4.controller;

import org.example.casestudymodule4.model.DTO.PlayerStatusDTO;
import org.example.casestudymodule4.model.Player;

import org.example.casestudymodule4.model.DTO.PlayerDTO;

import org.example.casestudymodule4.model.Status;

import org.example.casestudymodule4.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/player")
public class PlayerController {
@Autowired
    private IPlayerService playerService;

    @GetMapping("")
    public ResponseEntity<List<Player>> findAll(@RequestParam(value = "name", required = false) String name) {

        List<Player> list;
        if (name != null) {
            list = playerService.findPlayersByName(name);
        } else {
            list = playerService.findAll();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity<List<Player>> findAll() {
//        return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
//    }

    @GetMapping("/status/{id}")
    public ResponseEntity<List<Player>> findByStatus(Status status) {
        return new ResponseEntity<>(playerService.findPlayersByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> finOne(@PathVariable Long id) {
        Player p = playerService.findByid(id);
        return new ResponseEntity<>(playerService.findByid(id), HttpStatus.OK);
    }

@PostMapping("/upload")
public ResponseEntity<?> saveUpload(PlayerDTO playerDTO) {
    playerService.savePlayerDTO(playerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        playerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<?> edit(@PathVariable Long id,  PlayerDTO playerDTO){
        playerDTO.setId(id);
        Optional<Player> computerOptional = Optional.ofNullable(playerService.findByid(id));
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            playerDTO.setId(id);
            playerService.savePlayerDTO(playerDTO);
            return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/change-status")
    public ResponseEntity<?> changeStatus(@RequestBody List<PlayerStatusDTO> playerStatusDTOS){
        try {
            playerService.changeStatus(playerStatusDTOS);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

