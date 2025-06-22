package com.futstats.futstats_app.config;

import com.futstats.futstats_app.league.model.League;
import com.futstats.futstats_app.league.repository.LeagueRepository;
import com.futstats.futstats_app.shared.enums.Country;
import com.futstats.futstats_app.team.model.Team;
import com.futstats.futstats_app.team.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
    public class DataInitializer implements CommandLineRunner {

        private final LeagueRepository leagueRepository;
        private final TeamRepository teamRepository;

        @Autowired
        public DataInitializer(LeagueRepository leagueRepository, TeamRepository teamRepository) {
            this.leagueRepository = leagueRepository;
            this.teamRepository = teamRepository;
        }

        @Transactional
        @Override
        public void run(String... args) throws Exception {
            League premierLeague = getOrCreateLeague("Premier League", Country.UNITED_KINGDOM);
            League serieA = getOrCreateLeague("Seria A", Country.ITALY);
            League bundesliga = getOrCreateLeague("Bundesliga", Country.GERMANY);
            League laLiga = getOrCreateLeague("La Liga", Country.SPAIN);
            League efbetLiga = getOrCreateLeague("Efbet Liga", Country.BULGARIA);
            League liga1 = getOrCreateLeague("Liga 1", Country.FRANCE);

            List<Team> teams = new ArrayList<>();

            teams.add(Team.builder().fullName("Manchester City FC").nickname("Man City").founded(LocalDate.of(1880, 1, 1))
                    .ground("Etihad Stadium").capacity(53400).owner("City Football Group").headCoach("Pep Guardiola")
                    .leagueName(premierLeague).build());

            teams.add(Team.builder().fullName("Liverpool FC").nickname("Liverpool").founded(LocalDate.of(1892, 6, 3))
                    .ground("Anfield").capacity(54000).owner("Fenway Sports Group").headCoach("Arne Slot")
                    .leagueName(premierLeague).build());

            teams.add(Team.builder().fullName("FC Barcelona").nickname("Barça").founded(LocalDate.of(1899, 11, 29))
                    .ground("Spotify Camp Nou").capacity(99354).owner("Socios").headCoach("Hansi Flick")
                    .leagueName(laLiga).build());

            teams.add(Team.builder().fullName("Real Madrid CF").nickname("Real").founded(LocalDate.of(1902, 3, 6))
                    .ground("Santiago Bernabéu").capacity(81044).owner("Socios").headCoach("Carlo Ancelotti")
                    .leagueName(laLiga).build());

            teams.add(Team.builder().fullName("FC Bayern Munich").nickname("Bayern").founded(LocalDate.of(1900, 2, 27))
                    .ground("Allianz Arena").capacity(75000).owner("FC Bayern München AG").headCoach("Vincent Kompany")
                    .leagueName(bundesliga).build());

            teams.add(Team.builder().fullName("Borussia Dortmund").nickname("BVB").founded(LocalDate.of(1909, 12, 19))
                    .ground("Signal Iduna Park").capacity(81365).owner("Borussia Dortmund GmbH & Co. KGaA")
                    .headCoach("Nuri Şahin").leagueName(bundesliga).build());

            teams.add(Team.builder().fullName("Juventus FC").nickname("Juve").founded(LocalDate.of(1897, 11, 1))
                    .ground("Allianz Stadium").capacity(41507).owner("Agnelli family").headCoach("Thiago Motta")
                    .leagueName(serieA).build());

            teams.add(Team.builder().fullName("AC Milan").nickname("Milan").founded(LocalDate.of(1899, 12, 16))
                    .ground("San Siro").capacity(80018).owner("RedBird Capital").headCoach("Paulo Fonseca")
                    .leagueName(serieA).build());

            teams.add(Team.builder().fullName("Paris Saint-Germain FC").nickname("PSG").founded(LocalDate.of(1970, 8, 12))
                    .ground("Parc des Princes").capacity(47929).owner("Qatar Sports Investments")
                    .headCoach("Luis Enrique").leagueName(liga1).build());

            teams.add(Team.builder().fullName("Olympique Marseille").nickname("OM").founded(LocalDate.of(1899, 8, 31))
                    .ground("Stade Vélodrome").capacity(67394).owner("Frank McCourt")
                    .headCoach("Roberto De Zerbi").leagueName(liga1).build());

            teams.add(Team.builder().fullName("PFC Ludogorets Razgrad").nickname("The Eagles").founded(LocalDate.of(2001, 6, 18))
                    .ground("Huvepharma Arena").capacity(10.500).owner("Kiril Domuschiev")
                    .headCoach("Rui Mota").leagueName(efbetLiga).build());

            teams.add(Team.builder().fullName("PFC Levski Sofia").nickname("Levski").founded(LocalDate.of(1914, 5, 24))
                    .ground("Georgi Asparuhov Stadium").capacity(25000).owner("Nasko Sirakov")
                    .headCoach("Julio Velázquez").leagueName(efbetLiga).build());

            for (Team team : teams) {
                if (teamRepository.findByFullName(team.getFullName()).isEmpty()) {
                    teamRepository.save(team);
                }
            }
        }

        private League getOrCreateLeague(String name, Country country) {
            Optional<League> leagueOpt = leagueRepository.findByLeagueName(name);
            return leagueOpt.orElseGet(() -> leagueRepository.save(
                    League.builder().leagueName(name).Country(country).build()
            ));
        }
    }
