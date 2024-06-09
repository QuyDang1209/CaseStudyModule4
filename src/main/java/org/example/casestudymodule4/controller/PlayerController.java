package org.example.casestudymodule4.controller;

import jakarta.validation.Valid;
import org.example.casestudymodule4.model.Player;
import org.example.casestudymodule4.model.dto.PlayerDTO;
import org.example.casestudymodule4.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<String> saveUpload(@Valid @ModelAttribute PlayerDTO playerDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().toString());
        }
    playerService.savePlayerDTO(playerDTO);
    //        return new ResponseEntity<>(HttpStatus.CREATED);
    return ResponseEntity.ok("Player created successfully");
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
}
