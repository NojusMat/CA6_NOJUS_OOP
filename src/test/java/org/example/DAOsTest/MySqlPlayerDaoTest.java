package org.example.DAOsTest;

import com.google.gson.Gson;
import org.example.Exceptions.DaoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.DTOsTest.Player;

class MySqlPlayerDaoTest {
    private PlayerDaoInterface PlayerDao;
    private Gson gsonParser;
    private PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

    @Test
    void findAllPlayers() {
        System.out.println("findAllPlayerresultSet()");
    }

    @Test
    void findPlayerById() throws DaoException {
        System.out.println("findPlayerById()");
        System.out.println("Test can we find a player?");
        Player expPlayer = new Player(21,"Bob","Gilbert","Lakers",199.23,2999,21);
        Player actPlayer = IPlayerDao.findPlayerById(21);
        assertEquals(expPlayer, actPlayer);
    }

    @Test
    void insertPlayer() throws DaoException {
        System.out.println("insertPlayer");
        System.out.println("Test can we insert a player?");
        Player testPlayer = new Player(22,"jeff","lazar","Lakers",199.23,29,21);
//        IPlayerDao.insertPlayer(testPlayer);
        Player insertedPlayer = IPlayerDao.findPlayerById(22);
        assertEquals(testPlayer, insertedPlayer);

    }

    @Test
    void deletePlayerById() {
        System.out.println("deletePlayerById()");
    }

    @Test
    void filterPlayer() {
        System.out.println("filterPlayer()");
    }

    @Test
    void findAllPlayersJson() {
        System.out.println("List of all players in json()");
    }

    @Test
    void findPlayerByIdJson() {
    }
}