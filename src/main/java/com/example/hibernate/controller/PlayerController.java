package com.example.hibernate.controller;

import com.example.hibernate.domain.Player;
import com.example.hibernate.services.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<?> createPlayer(@RequestBody Player player){
        return playerService.createPlayer(player);
    }

    @PutMapping("/update/{idPlayer}")
    public ResponseEntity<?> updatePlayer(@RequestBody Player player, @PathVariable Integer idPlayer){
        return playerService.updatePlayer(player, idPlayer);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllPlayer(){
        return playerService.findAllPlayer();
    }

    @DeleteMapping("/delete/{idPlayer}")
    public void deletePlayer(@PathVariable Integer idPlayer){
      playerService.deletePlayer(idPlayer);
    }


}
