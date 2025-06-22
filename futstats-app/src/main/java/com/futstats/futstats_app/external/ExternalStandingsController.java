package com.futstats.futstats_app.external;

import org.springframework.ui.Model;
import com.futstats.futstats_app.external.dto.StandingEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/external/standings")
public class ExternalStandingsController {
    @Autowired
    ExternalStandingsService service;

    @GetMapping("/{leagueCode}")
    public String show(@PathVariable String leagueCode, Model m) {
        List<StandingEntry> table = service.fetchStandings(leagueCode);
        m.addAttribute("standings", table);
        m.addAttribute("leagueCode", leagueCode);
        return "external/standings";
    }
}
