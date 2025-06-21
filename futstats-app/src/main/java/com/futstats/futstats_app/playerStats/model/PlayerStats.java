package com.futstats.futstats_app.playerStats.model;

import com.futstats.futstats_app.player.model.Player;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "playerStats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int matchesPlayed;
    @Column(nullable = false)
    private int goals;
    @Column(nullable = false)
    private int assists;
    @Column(nullable = false)
    private int yellowCards;
    @Column(nullable = false)
    private int redCards;
    @Column(nullable = false)
    private int minutesPlayed;
    @Column(nullable = false)
    private int cleanSheets; // за вратари или защитници

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
