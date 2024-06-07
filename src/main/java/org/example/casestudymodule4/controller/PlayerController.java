package org.example.casestudymodule4.controller;

import org.example.casestudymodule4.model.Player;
import org.example.casestudymodule4.model.dto.PlayerDTO;
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
    public ResponseEntity<List<Player>> findAll() {
        return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
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
    private ResponseEntity<?> edit(@PathVariable Long id,  PlayerDTO player){
        player.setId(id);
        Optional<Player> computerOptional = Optional.ofNullable(playerService.findByid(id));
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            player.setId(id);
            playerService.savePlayerDTO(player);
            return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
        }
    }
}
