package org.example.DAOs;


import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import java.util.List;


public interface PlayerDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;

    public Player findPlayerById(int id)throws DaoException;

    public void addPlayer()throws DaoException;

    public void deletePlayerById(int id)throws DaoException;


}

