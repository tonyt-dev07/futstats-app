package com.futstats.futstats_app.leagueStanding.repository;

import com.futstats.futstats_app.leagueStanding.model.LeagueStanding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeagueStandingRepository extends JpaRepository<LeagueStanding, UUID> {

}
