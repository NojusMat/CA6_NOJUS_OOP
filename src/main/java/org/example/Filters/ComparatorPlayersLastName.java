package org.example.Filters;



import org.example.DTOs.Player;

import java.util.Comparator;

public class ComparatorPlayersLastName implements Comparator<Player>
{


    @Override
    public int compare(Player p1, Player p2)
    {
        if(p1.getLastName().equalsIgnoreCase(p2.getLastName()))
        {
            return p1.getId() - p2.getId();
        }

        return p1.getLastName().compareToIgnoreCase(p2.getLastName());

    }

}
