package org.example.DTOs;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        Set<Integer> cache = new HashSet<>();
        cache.add(1);
        cache.add(2);
        player = new Player(1, "John", "Doe", "Team A", 185.4, 80, 20.5f);
    }

    @Test
    public void testGetId() {
        assertEquals(1, player.getId());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", player.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", player.getLastName());
    }

    @Test
    public void testGetTeam() {
        assertEquals("Team A", player.getTeam());
    }

    @Test
    public void testGetHeight_in_Cm() {
        assertEquals(185.4, player.getHeight_in_Cm(), 0.001);
    } // the 0.001 provides the tolerance allowed in this case it can be 0.001 either way of 185.4
    @Test
    public void testGetWeight_in_Kg() {
        assertEquals(80, player.getWeight_in_Kg());
    }

    @Test
    public void testGetPoints_Per_Game() {
        assertEquals(20.5f, player.getPoints_Per_Game(), 0.001);
    }

    @Test
    public void testSetId() {
        player.setId(1);
        assertEquals(1, player.getId());
    }

    @Test
    public void testSetFirstName() {
        player.setFirstName("John");
        assertEquals("John", player.getFirstName());
    }

    @Test
    public void testSetLastName() {
        player.setLastName("Smith");
        assertEquals("Smith", player.getLastName());
    }

    @Test
    public void testSetTeam() {
        player.setTeam("Team B");
        assertEquals("Team B", player.getTeam());
    }

    @Test
    public void testSetHeight_in_Cm() {
        player.setHeight_in_Cm(180.0);
        assertEquals(180.0, player.getHeight_in_Cm(), 0.001);
    }

    @Test
    public void testSetWeight_in_Kg() {
        player.setWeight_in_Kg(75);
        assertEquals(75, player.getWeight_in_Kg());
    }

    @Test
    public void testSetPoints_Per_Game() {
        player.setPoints_Per_Game(15.5f);
        assertEquals(15.5f, player.getPoints_Per_Game(), 0.001);
    }

    @Test
    public void testCompareTo() {
        Player tallerPlayer = new Player(2, "Mike", "Smith", "Team A", 190.0, 85, 18.5f);
        assertEquals(-1, player.compareTo(tallerPlayer));
    }

    @Test
    public void testHashCode() {
        Player playerWithSameAttributes = new Player(1, "John", "Doe", "Team A", 185.4, 80, 20.5f);
        assertEquals(player.hashCode(), playerWithSameAttributes.hashCode());
    }
}
//    @Test
//    public void testToString() {
//        String expected = "{ID=1,| First Name=John,| Last Name=Doe,| Team=Team A,| Height in Cm=185.4,| Weight in  Kg=80,| Points Per Game=20.5}";
//        assertEquals}