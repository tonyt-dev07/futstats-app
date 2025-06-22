package com.futstats.futstats_app.league.repository;

import com.futstats.futstats_app.league.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LeagueRepository extends JpaRepository<League, UUID> {
    Optional<League> findByLeagueName(String leagueName);
}

