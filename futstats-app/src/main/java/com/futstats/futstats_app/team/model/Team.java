package com.futstats.futstats_app.team.model;

import com.futstats.futstats_app.league.model.League;
import com.futstats.futstats_app.leagueStanding.model.LeagueStanding;
import com.futstats.futstats_app.match.model.Match;
import com.futstats.futstats_app.player.model.Player;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false)
    private LocalDate founded;
    @Column(nullable = false)
    private String ground;
    @Column(nullable = false)
    private String capacity;
    @Column(nullable = false)
    private String owner;
    @Column(nullable = false)
    private String headCoach;

    @OneToMany(mappedBy = "currentTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> player = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League leagueName;

    @OneToMany(mappedBy = "homeTeam")
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "awayTeam")
    private List<Match> awayMatches;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeagueStanding> standings = new ArrayList<>();





}
