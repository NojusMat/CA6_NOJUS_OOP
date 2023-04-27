package org.example.DAOs;

import com.google.gson.Gson;
import org.example.DTOs.Arena;
import org.example.DTOs.Teams;
import org.example.Exceptions.DaoException;
import org.example.Filters.IFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlArenaDao extends MySqlDao implements ArenaDaoInterface {

    @Override
    public List<Arena> findAllArenas() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Arena> arenaList = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM ARENA";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int arena_ID = resultSet.getInt("arena_ID");
                String arena_name = resultSet.getString("arena_name");
                int capacity = resultSet.getInt("capacity");

                Arena a = new Arena(arena_ID, arena_name, capacity);
                arenaList.add(a);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllArenasSet() " + e.getMessage());
        }
        return arenaList;     // may be empty
    }

    @Override
    public String findTeamsByArena(int arena_ID) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Teams> teamArena = new ArrayList<>();
        try {
            connection = this.getConnection();



            String query = "SELECT * FROM TEAMS WHERE arena_ID = ?"+
                    "JOIN TEAMS ON ARENA_ID = TEAMS.ARENA_ID"+
                    "JOIN ARENA ON ARENA_ID = ARENA.ARENA_ID"+
                    "WHERE TEAMS.ARENA_ID IN(SELECT team FROM TEAMS WHERE arena_ID = ?) ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, arena_ID);



            resultSet = preparedStatement.executeQuery();
            if ((resultSet.next())) {

                String team = resultSet.getString("team");
                String team_city = resultSet.getString("team_city");
                String team_state = resultSet.getString("team_state");
                String conference = resultSet.getString("conference");
                String division = resultSet.getString("division");

                teamArena = (List<Teams>) new Teams(team,team_city, team_state, conference,division,arena_ID);

            }
        } catch (SQLException e) {
            throw new DaoException("findTeamByArenaID() " + e.getMessage());
        }
        return teamArena.toString();     // reference to User object, or null value
    }

    @Override
    public List<Arena> filterArenaCapacity(IFilter filter) throws DaoException
    {
        List<Arena> filteredList = new ArrayList<>();  // gets list of arenas and adds it to a array list of filters

        try
        {
            List<Arena> allArenas = findAllArenas();
            for(Arena arena : allArenas)  // advanced for loop itterating through all arenas
            {
                if(filter.matches(arena))
                {
                    filteredList.add(arena); // checking if the filter that was chosen matches and adds it to list (filtered list)
                }
            }
        }
        catch (DaoException daoe)
        {
            System.out.println("filterPlayer() " + daoe.getMessage());
        }

        return filteredList;
    }

    @Override
    public Arena insertArena(int arena_ID, String arena_name, int capacity) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Arena arena = null;

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "INSERT INTO ARENA (arena_ID,arena_name,capacity) VALUES ( ?, ?, ?)";
            ps = connection.prepareStatement(query);

            ps.setInt(1, arena_ID);
            ps.setString(2, arena_name);
            ps.setInt(3, capacity);

            ps.executeUpdate();

        }


        // Execute the Prepared Statement and get a result set
        catch (SQLException e) {
            throw new DaoException("insertArena() " + e.getMessage());
        }
        return arena;     // reference to User object, or null value
    }

    @Override
    public void deleteArenaByArenaID(int arena_ID) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;


        try {
            connection = this.getConnection();

            String query = "DELETE FROM ARENA WHERE ARENA_ID = ?";
            ps = connection.prepareStatement(query);

            ps.setInt(1, arena_ID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("deletePlayerById() " + e.getMessage());
        }

    }

    @Override
    public String findAllArenasJson() throws DaoException {
        //Using a PreparedStatement to execute SQL...
        Gson gsonParser = new Gson();

        List<Arena> arenaList = new ArrayList<>();

        // call a method in the DAO
        gsonParser = new Gson();
        String allArenasJson = gsonParser.toJson(arenaList);

        System.out.println("List of all arenas in json()");
        System.out.println(allArenasJson);

        return allArenasJson;

    }

//    @Override
//    public String findArenaByJsonArenaID(int arena_ID) throws DaoException {
//
//        Gson gsonParser = new Gson();
//        Arena arena = findTeamsByArena(arena_ID);
//
//        gsonParser = new Gson();
//        String findArenaJson = gsonParser.toJson(arena);
//
//
//        System.out.println("findArenaByJsonArenaID()");
//
//        return findArenaJson;
//    }


}
