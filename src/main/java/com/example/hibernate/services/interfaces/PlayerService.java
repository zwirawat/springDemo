package com.example.hibernate.services.interfaces;

import com.example.hibernate.domain.Player;
import org.springframework.http.ResponseEntity;

/* design table */
public interface PlayerService {
    public ResponseEntity<?> createPlayer(Player player);
    public ResponseEntity<?> updatePlayer(Player player, Integer idPlayer);
    public ResponseEntity<?> findAllPlayer();
    public void deletePlayer(Integer idPlayer);
}
