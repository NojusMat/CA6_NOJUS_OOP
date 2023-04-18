package org.example.DAOsTest;


import org.example.DTOsTest.Player;
import org.example.Exceptions.DaoException;
import org.example.Filters.IFilter;

import java.util.List;


public interface PlayerDaoInterface
{
    List<Player> findAllPlayers() throws DaoException;

    Player findPlayerById(int id)throws DaoException;

    Player insertPlayer(String firstName,String lastName,String team,double height_in_Cm,float points_Per_Game,int weight_in_Kg)throws DaoException;

    void deletePlayerById(int id)throws DaoException;

    List<Player> filterPlayer(IFilter filter) throws DaoException;

    String findAllPlayersJson()throws DaoException;

    String findPlayerByIdJson(int id)throws DaoException;


}

