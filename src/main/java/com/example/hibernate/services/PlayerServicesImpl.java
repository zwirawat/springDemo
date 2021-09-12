package com.example.hibernate.services;

import com.example.hibernate.domain.Player;
import com.example.hibernate.repositories.PlayerRepository;
import com.example.hibernate.services.interfaces.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlayerServicesImpl implements PlayerService {

    /*
        การเรียกใช้ getter(), setter(), toString()

        Solution 1: เรียกใช้ Constructor แบบดั้งเดิม
        private final PlayerRepository playerRepository;
        public PlayerServicesImpl(PlayerRepository playerRepository) {
            this.playerRepository = playerRepository;
        }

        Solution 2: มี Repositories หลายตัว
        @RequiredArgsConstructor
        private final PlayerRepository playerRepository;

        Solution 3: @Autowide
        private PlayerRepository playerRepository;

    */
    private final PlayerRepository playerRepository;

    @Override
    public ResponseEntity<?> createPlayer(Player player) {
        return ResponseEntity.ok(playerRepository.save(player));
    }

    @Override
    public ResponseEntity<?> updatePlayer(Player player, Integer idPlayer) {
        Optional<Player> player1 = playerRepository.findById(idPlayer);
        if(player1.isPresent()){
            Player player2 = player1.get();
            player2.setName(player.getName());
            player.setJob(player.getJob());
            return new ResponseEntity<>(playerRepository.save(player2), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> findAllPlayer() {
        return ResponseEntity.ok(playerRepository.findAll());
    }

    @Override
    public void deletePlayer(Integer idPlayer) {
        playerRepository.deleteById(idPlayer);
    }


}
