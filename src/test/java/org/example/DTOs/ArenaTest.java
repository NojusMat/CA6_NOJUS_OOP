package org.example.DTOs;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArenaTest {
    private Arena arena;

    @BeforeEach
    public void setUp(){
        Set<Integer> cache = new HashSet<>();
        cache.add(1);
        cache.add(2);
        arena = new Arena(1, "Test Stadium",  20000 );
    }

    @Test
    void getArena_ID() {assertEquals(1, arena.getArena_ID());
    }

    @Test
    void setArena_ID() {
        arena.setArena_ID(1);
        assertEquals(1, arena.getArena_ID());
    }

    @Test
    void getArena_name() {assertEquals("Test Stadium", arena.getArena_name());
    }

    @Test
    void setArena_name() {
        arena.setArena_name("Test Stadium");
        assertEquals("Test Stadium", arena.getArena_name());
    }

    @Test
    void getCapacity() {
        assertEquals(20000,arena.getCapacity());
    }

    @Test
    void setCapacity() {
        arena.setCapacity(20000);
        assertEquals(20000, arena.getCapacity());
    }


//    @Test
//    void compareTo() {
//        Arena largestCapacity = new Arena(2, "Second Arena", 45000);
//        assertEquals(-1, arena.compareTo(largestCapacity));
//    }
}