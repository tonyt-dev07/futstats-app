package com.futstats.futstats_app.external;

import com.futstats.futstats_app.external.dto.StandingEntry;
import com.futstats.futstats_app.external.dto.StandingResponse;
import com.futstats.futstats_app.external.dto.StandingSeason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ExternalStandingsService {
    @Value("${football.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public List<StandingEntry> fetchStandings(String leagueCode) {
        String url = "https://api.football-data.org/v4/competitions/" + leagueCode + "/standings";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", apiKey);
        HttpEntity<Void> req = new HttpEntity<>(headers);

        StandingResponse resp = restTemplate.exchange(
                url, HttpMethod.GET, req, StandingResponse.class
        ).getBody();

        return resp.getStandings().stream()
                .filter(s -> "TOTAL".equals(s.getType()))
                .findFirst()
                .map(StandingSeason::getTable)
                .orElse(Collections.emptyList());
    }
}
