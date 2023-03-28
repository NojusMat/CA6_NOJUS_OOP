package org.example;

import org.example.DTOs.Player;

import java.util.Comparator;

public class ComparePlayersByWeight implements Comparator<Player>
{
    @Override
    public int compare(Player p1, Player p2)
    {
        return p1.getWeight_in_Kg() - p2.getWeight_in_Kg();
    }
}
