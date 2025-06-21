package com.futstats.futstats_app.league.model;

import com.futstats.futstats_app.leagueStanding.model.LeagueStanding;
import com.futstats.futstats_app.player.model.Player;
import com.futstats.futstats_app.shared.enums.Country;
import com.futstats.futstats_app.team.model.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leagues")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String leagueName;

    @Enumerated(EnumType.STRING)
    private Country Country;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeagueStanding> standings = new ArrayList<>();

    @OneToMany(mappedBy = "leagueName")
    private List<Team> teams  = new ArrayList<>();

}
