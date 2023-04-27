package org.example.DTOs;

public class Game {

    private int game_ID;
    private String homeTeam_name;
    private String awayTeam_name;
    private int homeTeam_score;
    private final int awayTeam_score;

    public Game(int game_ID, String homeTeam_name, String awayTeam_name,int homeTeam_score, int awayTeam_score)
    {
        this.game_ID = game_ID;
        this.homeTeam_name = homeTeam_name;
        this.awayTeam_name = awayTeam_name;
        this.homeTeam_score=homeTeam_score;
        this.awayTeam_score = awayTeam_score;
    }

    public int getGame_ID()
    {
        return game_ID;
    }

    public void setGame_ID(int game_ID)
    {
        this.game_ID = game_ID;
    }

    public String getHomeTeam_name()
    {
        return homeTeam_name;
    }

    public void setHomeTeam_name(String homeTeam_name)
    {
        this.homeTeam_name = homeTeam_name;
    }

    public String getAwayTeam_name()
    {
        return awayTeam_name;
    }

    public void setAwayTeam_name(String awayTeam_name)
    {
        this.awayTeam_name = awayTeam_name;
    }

    public int getHomeTeam_score()
    {
        return homeTeam_score;
    }

    public void setHomeTeam_score(int homeTeam_score)
    {
        this.homeTeam_score = homeTeam_score;
    }

    public int getAwayTeam_score()
    {
        return awayTeam_score;
    }

    public void setAwayTeam_score(int awayTeam_score)
    {
        this.awayTeam_name = awayTeam_name;
    }


    @Override
    public String toString()
    {
        return "Game{" + "Game ID=" + game_ID + "," + homeTeam_name +" VS " + awayTeam_name +
                ": " + homeTeam_score +"-" +awayTeam_name+'}';
    }


}
