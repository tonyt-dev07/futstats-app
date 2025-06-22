package com.futstats.futstats_app.team.repository;

import com.futstats.futstats_app.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {

    Collection<Object> findByFullName(String fullName);
}
