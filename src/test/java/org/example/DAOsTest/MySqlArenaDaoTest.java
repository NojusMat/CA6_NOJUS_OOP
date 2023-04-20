package org.example.DAOsTest;

import org.example.DTOsTest.Player;
import org.example.Exceptions.DaoException;
import org.example.Filters.IFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.example.DTOsTest.Arena;

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

//    @Test
//    void testfindTeamsByArena() {
//        System.out.println("TEST findTeamsByArena");
//        try {
//            Arena arena = ArenaDao.findTeamsByArena();
//            assertNotNull(player);
//            assertEquals(player_id, player.getId());
//            System.out.println("Success");
//        } catch (DaoException e) {
//            fail("testFindPlayer has Failed:" + e.getMessage());
//        }
//
//    }


    @Test
    void testfilterArenaCapacity() {
//        System.out.println("Test filterArenaCapacity");
//        try {
//            List<Arena> arenaList = ArenaDao.filterArenaCapacity(new IFilter() {
//
//                @Override
//                public boolean matches(Object other) {
//                    return false;
//                }
//
//
//                @Override
//                public boolean matches(Arena arena) {
//                    return arena.getCapacity().equals("Test Capacity");
//                }
//            });
//            assertNotNull(arenaList);
//        }catch (DaoException e) {
//            fail("Filter has Failed:" + e.getMessage());
//        }
//    }
    }


    @Test
    void testinsertArena() {
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