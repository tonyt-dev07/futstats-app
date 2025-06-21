package com.futstats.futstats_app.player.model;

import com.futstats.futstats_app.playerStats.model.PlayerStats;
import com.futstats.futstats_app.shared.enums.Nationality;
import com.futstats.futstats_app.team.model.Team;
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
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Nationality nationality;
    @Enumerated(EnumType.STRING)
    private Positions positions;

    @Enumerated(EnumType.STRING)
    private Foot preferredFoot;

    private String imageUrl;

    @Column(nullable = false)
    private String height;

    @Column(nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team currentTeam;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerStats> playerStatsHistory = new ArrayList<>();


    // TODO: 💡 Допълнителни идеи за разширяване
    //История на отбори – PlayerTeamHistory с периоди на престой.
    //
    //История по сезони – SeasonStats ако пазиш статистики на сезон.
    //
    //Контракт информация – кога започва и свършва договор с отбора.
    //
    //Наказания, контузии – отделни таблици с дати и видове.
}
