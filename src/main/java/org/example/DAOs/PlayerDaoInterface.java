package org.example.DAOs;


import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import org.example.IFilter;

import java.util.List;


public interface PlayerDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;

    public Player findPlayerById(int id)throws DaoException;

    public Player insertPlayer(String firstName,String lastName,String team,double height_in_Cm,float points_Per_Game,int weight_in_Kg)throws DaoException;

    public void deletePlayerById(int id)throws DaoException;

    List<Player> filterPlayer(IFilter filter) throws DaoException;

    boolean checkIdExists(int id) throws DaoException;


}

