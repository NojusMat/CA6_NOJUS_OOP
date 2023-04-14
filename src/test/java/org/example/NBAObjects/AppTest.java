package org.example.NBAObjects;

import org.example.DTOs.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void insertPlayer(){
        System.out.println("Test can we add a player?");
        Player player = new Player(20,"Bob","Gilbert","Lakers",199.23,2999,21);



    }

}