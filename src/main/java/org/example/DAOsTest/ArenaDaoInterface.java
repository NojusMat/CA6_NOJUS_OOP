package org.example.DAOsTest;


import org.example.DTOsTest.Arena;
import org.example.Exceptions.DaoException;
import org.example.Filters.IFilter;

import java.util.List;


public interface ArenaDaoInterface
{
    List<Arena> findAllArenas() throws DaoException;

    String findTeamsByArena(int arena_ID)throws DaoException;
    List<Arena> filterArenaCapacity(IFilter filter) throws DaoException;

    Arena insertArena(int arena_ID, String arena_name, int capacity)throws DaoException;

    void deleteArenaByArenaID(int arena_ID)throws DaoException;
    String findAllArenasJson()throws DaoException;

//    String findArenaByJsonArenaID(int id)throws DaoException;

}

