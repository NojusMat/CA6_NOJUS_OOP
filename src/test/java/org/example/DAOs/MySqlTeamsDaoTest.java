package org.example.DAOs;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Exceptions.DaoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.DTOs.Teams;

import java.util.List;

public class MySqlTeamsDaoTest {
    private TeamsDaoInterface TeamsDao;

    @BeforeEach
    void setUp() {
        TeamsDao = new MySqlTeamsDao();
    }

    @AfterEach
    void tearDown() {
        TeamsDao = null;
    }

    @Test
    void TestfindAllTeams() {
        System.out.println("TEST findAllTeams");
        try {
            List<Teams> teamsList = TeamsDao.findAllTeams();
            assertNotNull(teamsList);
            System.out.println("Success");
        } catch (DaoException e) {
            fail("findAllTeams has Failed:" + e.getMessage());

        }
    }

        @Test
        void testFindTeamsByCity() { //// not able to get this to work
            System.out.println("TEST FindTeamsByCity");
            try {
                String name_of_teams_city = "Georgia";
                Teams teams = TeamsDao.findTeamsByCity(name_of_teams_city);
                assertNotNull(teams);
                assertEquals(name_of_teams_city, teams.getTeam_city());
                System.out.println("Success");

            } catch (DaoException e) {
                fail("test FindTeamsByCity has Failed:" + e.getMessage());
            }

        }



        @Test
        void testinsertTeam() {  // problem with this test
            System.out.println("TEST insertTeam");
            try {
                String team = "Giants";
                String team_city = "Miami";
                String team_state = "Florida";
                String division = "Pacific";
                int arena_ID = 87654;
                Teams newteam = TeamsDao.insertTeam(team, team_city, team_state, division, arena_ID);
                assertNotNull(newteam);
                assertEquals(team, newteam.getTeam());
                assertEquals(team_city, newteam.getTeam_city());
                assertEquals(team_state, newteam.getTeam_state());
                assertEquals(division, newteam.getDivision());
                assertEquals(arena_ID, newteam.getArena_ID());
                System.out.println("Success");
            } catch (DaoException e) {
                fail("InsertPlayer has Failed:" + e.getMessage());
            }



        }

        @Test
        void testDeleteTeamByName() {
            System.out.println("TEST delete player");
            try {
                String team ="RandomTeam";
                TeamsDao.deleteTeamByName(team);
                System.out.println("Success");
            } catch (DaoException e) {
                fail("TEST delete player has Failed:" + e.getMessage());
            }
        }

}