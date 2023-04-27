package org.example.DAOs;


import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import org.example.Filters.IFilter;

import java.util.List;


public interface PlayerDaoInterface
{
    List<Player> findAllPlayers() throws DaoException; // retrieves all players in list of players

    Player findPlayerById(int id)throws DaoException; // find player by user chosen ID

    Player insertPlayer(String firstName,String lastName,String team,double height_in_Cm,float points_Per_Game,int weight_in_Kg)throws DaoException; // inserts a play with chosen parameters

    void deletePlayerById(int id)throws DaoException; // deletes a player of chosen ID

    List<Player> filterPlayer(IFilter filter) throws DaoException; // filters the players

    String findAllPlayersJson()throws DaoException; // displays all players as a json

    String findPlayerByIdJson(int id)throws DaoException; // displays a player chosen by user in json format


}

