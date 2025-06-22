package com.futstats.futstats_app.external.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StandingSeason {
    private String type;
    private List<StandingEntry> table;
}
