package org.example.DAOs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.example.DTOs.Player;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MySqlPlayerDaoTest {
    private PlayerDaoInterface PlayerDao;
    private Gson gsonParser;

    @BeforeEach
    void setUp()
    {
        PlayerDao = new MySqlPlayerDao();
        gsonParser = new Gson();

    }

    @Test
    void findAllPlayers() {
        System.out.println("findAllPlayerresultSet()");
    }

    @Test
    void findPlayerById() {
        System.out.println("findPlayerById()");
    }

    @Test
    void insertPlayer() {
        System.out.println("insertPlayer");

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