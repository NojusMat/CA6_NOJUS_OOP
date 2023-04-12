package org.example.DAOs;


import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import org.example.IFilter;

import java.util.List;


public interface ArenaDaoInterface
{
    List<Player> findAllPlayers() throws DaoException;

    Player findPlayerById(int id)throws DaoException;

    Player insertPlayer(String firstName,String lastName,String team,double height_in_Cm,float points_Per_Game,int weight_in_Kg)throws DaoException;

    void deletePlayerById(int id)throws DaoException;

    List<Player> filterPlayer(IFilter filter) throws DaoException;

    String findAllPlayersJson()throws DaoException;

    String findPlayerByIdJson(int id)throws DaoException;


}

