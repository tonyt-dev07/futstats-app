package com.futstats.futstats_app.external.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandingEntry {
    private int position, playedGames, won, draw, lost, points, goalsFor, goalsAgainst;
    private TeamInfo team;
}
