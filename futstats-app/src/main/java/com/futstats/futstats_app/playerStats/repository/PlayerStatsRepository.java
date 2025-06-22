package com.futstats.futstats_app.playerStats.repository;

import com.futstats.futstats_app.playerStats.model.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerStatsRepository  extends JpaRepository<PlayerStats, UUID> {

}
