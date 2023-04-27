package org.example.DAOs;


import org.example.DTOs.Arena;
import org.example.Exceptions.DaoException;
import org.example.Filters.IFilter;

import java.util.List;


public interface ArenaDaoInterface
{
    List<Arena> findAllArenas() throws DaoException; // find all arena data in the list Arena

    String findTeamsByArena(int arena_ID)throws DaoException; // finds team by Arena
    List<Arena> filterArenaCapacity(IFilter filter) throws DaoException;

    Arena insertArena(int arena_ID, String arena_name, int capacity)throws DaoException; // inserts Arena

    void deleteArenaByArenaID(int arena_ID)throws DaoException; // deletes arena by id
    String findAllArenasJson()throws DaoException; // displays all of arenas in json format

//    String findArenaByJsonArenaID(int id)throws DaoException; // displays arena chosen in json format

}

