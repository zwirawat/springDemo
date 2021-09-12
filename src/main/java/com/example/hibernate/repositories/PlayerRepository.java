package com.example.hibernate.repositories;

import com.example.hibernate.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/* id ระบุเป็น type แทน => Integer */
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
