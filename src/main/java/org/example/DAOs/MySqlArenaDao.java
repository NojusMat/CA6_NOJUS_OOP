package org.example.DAOs;

import org.example.DTOs.Arena;
import org.example.DTOs.Teams;
import org.example.Exceptions.DaoException;

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


}
