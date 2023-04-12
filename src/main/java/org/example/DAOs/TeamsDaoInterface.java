package org.example.DAOs;


import org.example.DTOs.Teams;
import org.example.Exceptions.DaoException;

import java.util.List;


public interface TeamsDaoInterface
{
    List<Teams> findAllTeams() throws DaoException;

    Teams findTeamsByCity(String team_city)throws DaoException;

    Teams insertTeam(String team,String team_city,String conference,String division,int arena_ID)throws DaoException;

    void deleteTeamByName(String team)throws DaoException;

    

//    public String findAllPlayersJson()throws DaoException;
//
//    public String findPlayerByIdJson(int id)throws DaoException;


}

