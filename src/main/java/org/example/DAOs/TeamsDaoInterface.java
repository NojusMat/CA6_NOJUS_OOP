package org.example.DAOs;


import org.example.DTOs.Teams;
import org.example.Exceptions.DaoException;

import java.util.List;


public interface TeamsDaoInterface
{
    List<Teams> findAllTeams() throws DaoException; // retries all teams

    Teams findTeamsByCity(String team_city)throws DaoException;  // retries a team based on city

    Teams insertTeam(String team,String team_city,String conference,String division,int arena_ID)throws DaoException; // adds a team with users chosen parameters

    void deleteTeamByName(String team)throws DaoException; // deletes team by team name



//    public String findAllPlayersJson()throws DaoException;
//
//    public String findPlayerByIdJson(int id)throws DaoException;


}

