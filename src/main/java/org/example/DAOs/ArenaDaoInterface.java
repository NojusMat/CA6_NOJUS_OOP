package org.example.DAOs;


import org.example.DTOs.Arena;
import org.example.DTOs.Player;
import org.example.DTOs.Teams;
import org.example.Exceptions.DaoException;
import org.example.IFilter;

import java.util.List;


public interface ArenaDaoInterface
{
    List<Arena> findAllArenas() throws DaoException;

    String findTeamsByArena(int arena_ID)throws DaoException;
    List<Arena> filterArenaCapacity(IFilter filter) throws DaoException;

    Arena insertArena(int arena_ID, String arena_name, int capacity)throws DaoException;




}

