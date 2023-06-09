package org.example.DAOs;

import com.google.gson.Gson;
import org.example.Exceptions.DaoException;
import org.example.Filters.IFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.DTOs.Player;

import java.lang.reflect.Type;
import java.util.List;

public class MySqlPlayerDaoTest {

    private PlayerDaoInterface PlayerDao;
    private Gson gsonParser;
    Type arrayListTrains;
    @BeforeEach
    void setUp() {

        PlayerDao = new MySqlPlayerDao();
        gsonParser = new Gson();
    }

    @AfterEach
    void tearDown() {
        PlayerDao = null;
    }

    @Test
    void TestfindAllPlayers(){
        System.out.println("TEST findAllPlayer");
        try {
            List<Player> playersList = PlayerDao.findAllPlayers();
            assertNotNull(playersList);
            System.out.println("Success");
        } catch (DaoException e) {
            fail("findAllPlayer has Failed:" + e.getMessage());

        }
    }

    @Test
    void testFindPlayer(){
        System.out.println("TEST FindPlayer");
        try {
            int player_id = 3;
            Player player = PlayerDao.findPlayerById(player_id);
            assertNotNull(player);
            assertEquals(player_id, player.getId());
            System.out.println("Success");
        } catch (DaoException e) {
            fail("testFindPlayer has Failed:" + e.getMessage());
        }

    }

    @Test
    void testInsertPlayer(){
        System.out.println("TEST InsertPlayer");
        try {
            String firstname = "Bob";
            String lastname = "Bobbingtong";
            String team = " Dream Team";
            double height_in_Cm = 199;
            float points_Per_Game = 21;
            int weight_in_Kg = 99;
            Player player = PlayerDao.insertPlayer(firstname, lastname, team, height_in_Cm, points_Per_Game, weight_in_Kg);
            assertNotNull(player);
            assertEquals(firstname, player.getFirstName());
            assertEquals(lastname, player.getLastName());
            assertEquals(team, player.getTeam());
            assertEquals(height_in_Cm, player.getHeight_in_Cm());
            assertEquals(points_Per_Game, player.getPoints_Per_Game());
            assertEquals(weight_in_Kg, player.getWeight_in_Kg());
            System.out.println("Success");
        } catch (DaoException e) {
            fail("InsertPlayer has Failed:" + e.getMessage());
        }

    }

    @Test
    void testDeletePlayerById(){
        System.out.println("TEST delete player");
        try {
            int player_id = 1;
            PlayerDao.deletePlayerById(player_id);
            System.out.println("Success");
        } catch (DaoException e) {
            fail("testFindPlayer has Failed:" + e.getMessage());
        }
    }

    @Test
    void testFilterPlayer()throws DaoException {
        System.out.println("Test Filter Player");
        try {
            List<Player> playersList = PlayerDao.filterPlayer(new IFilter() {

                @Override
                public boolean matches(Object other) {
                    return false;
                }

                @Override
                public boolean matches(Player player) {
                    return player.getLastName().equals("Test LastName");
                }
            });
        assertNotNull(playersList);
        }catch (DaoException e) {
                fail("Filter has Failed:" + e.getMessage());
            }
        }


    @Test
    void testFindAllPlayersJson() {
        System.out.println("Test of all players in json()");
        try {
            String playerJson = PlayerDao.findAllPlayersJson();
            assertNotNull(playerJson);
        } catch (DaoException e) {
            fail("Filter has Failed:" + e.getMessage());
        }
    }



    @Test
    void testFindPlayerByIdJson(){
        System.out.println("TEST findPlayerByIdJson");
        try{
            int player_id=2;
            String playerJson = PlayerDao.findPlayerByIdJson(player_id);
            assertNotNull(playerJson);
            assertEquals("{\"id\":2,\"firstName\":\"Anthony\",\"lastName\":\"Davis\",\"team\":\"Los_Angeles_Lakers\",\"height_in_Cm\":220.75,\"weight_in_Kg\":110,\"points_Per_Game\":23.3}",playerJson);
            System.out.println("Success");

        } catch (DaoException e) {
            fail("testfindPlayerByIdJson has Failed:" + e.getMessage());
        }
    }
}