package org.example.DAOs;

import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.example.DTOs.Arena;

import java.util.List;

public class MySqlArenaDaoTest {
    private ArenaDaoInterface ArenaDao;


    @BeforeEach
    void setUp() {
        ArenaDao = new MySqlArenaDao();
    }

    @AfterEach
    void tearDown() {
        ArenaDao = null;
    }

    @Test
    void testfindAllArenas() {
        System.out.println("TEST findAllArena");
        try {
            List<Arena> ArenaList = ArenaDao.findAllArenas();
            assertNotNull(ArenaList);
            System.out.println("Success");
        } catch (DaoException e) {
            fail("findAllArena has Failed:" + e.getMessage());
        }
    }

    @Test
    void testfindTeamsInArena() {
        System.out.println("TEST findTeamsByArena");
        try {
            int arenaID=12345;
            String arena = ArenaDao.findTeamsInArena(arenaID);
            assertNotNull(arena);
            assertEquals(arenaID, arena);
            System.out.println("Success");
        } catch (DaoException e) {
            fail("testfindTeamsInArena has Failed:" + e.getMessage());
        }

    }
    @Test
    void testinsertArena() {
        System.out.println("TEST insertArena");
        try {
            int arena_ID = 94848;
            String arena_name = "Bobbingtong";
            int capacity = 7654323;
            Arena arena = ArenaDao.insertArena(arena_ID, arena_name, capacity);
            assertNotNull(arena);
            assertEquals(arena_ID, arena.getArena_ID());
            assertEquals(arena_name, arena.getArena_name());
            assertEquals(capacity, arena.getCapacity());
            System.out.println("Success");
        } catch (DaoException e) {
            fail("InsertArena has Failed:" + e.getMessage());
        }
    }


    @Test
    void testdeleteArenaByArenaID() {
        System.out.println("TEST delete Arena");
        try {
            int arena_ID = 1234;
            ArenaDao.deleteArenaByArenaID(arena_ID);
            System.out.println("Success");
        } catch (DaoException e) {
            fail("testFindPlayer has Failed:" + e.getMessage());
        }
    }

    @Test
    void testfindAllArenasJson() {
        System.out.println("Test findAllArenasJson()");
        try {
            String arenaJson = ArenaDao.findAllArenasJson();
            assertNotNull(arenaJson);
        } catch (DaoException e) {
            fail("Filter has Failed:" + e.getMessage());
        }
    }
}