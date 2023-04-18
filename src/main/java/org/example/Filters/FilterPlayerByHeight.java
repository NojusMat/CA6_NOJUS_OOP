package org.example.Filters;


import org.example.DTOs.Player;

public class FilterPlayerByHeight implements IFilter
{
    private final double minRating;
    private final double maxRating;

    public FilterPlayerByHeight(double minRating, double maxRating)
    {
        this.minRating = minRating;
        this.maxRating = maxRating;
    }

    @Override
    public boolean matches(Object object)
    {
        Player player = (Player) object;

        return player.getHeight_in_Cm() >= minRating && player.getHeight_in_Cm() <= maxRating;
    }
}
