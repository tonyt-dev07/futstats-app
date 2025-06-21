package com.futstats.futstats_app.leagueStanding.model;

import com.futstats.futstats_app.league.model.League;
import com.futstats.futstats_app.team.model.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leagueStanding")
public class LeagueStanding {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(nullable = false)
    private int played;
    @Column(nullable = false)
    private int wins;
    @Column(nullable = false)
    private int draws;
    @Column(nullable = false)
    private int losses;
    @Column(nullable = false)
    private int goalsFor;
    @Column(nullable = false)
    private int goalsAgainst;
    @Column(nullable = false)
    private int goalDifference;
    @Column(nullable = false)
    private int points;

}
