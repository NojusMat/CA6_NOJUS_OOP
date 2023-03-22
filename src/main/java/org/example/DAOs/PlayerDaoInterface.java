package org.example.DAOs;


import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import java.util.List;


public interface PlayerDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;

//    public Player findPlayerById(int id )throws DaoException;
//
//    public void deletePlayerById()throws DaoException;
//
//    public Player addPlayer(String firstName, String lastName,String team, double height_in_Cm, int weight_in_Kg, float points_Per_Game)throws DaoException;


}

