package org.example.DAOs;

import com.google.gson.Gson;
import org.example.DTOs.Player;
import org.example.DTOs.Teams;
import org.example.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTeamsDao extends MySqlDao implements TeamsDaoInterface {
    @Override
    public List<Teams> findAllTeams() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Teams> teamsList = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM TEAMS";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String team = resultSet.getString("team");
                String team_city = resultSet.getString("team_city");
                String team_state = resultSet.getString("team_state");
                String conference = resultSet.getString("conference");
                String division = resultSet.getString("division");
                int arena_ID = resultSet.getInt("arena_ID");

                Teams t = new Teams(team, team_city, team_state, conference, division, arena_ID);
                teamsList.add(t);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllTeams() " + e.getMessage());
        }
        return teamsList;     // may be empty
    }

    @Override
    public Teams findTeamsByDivision(String division) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Teams teams = null;
        try {
            connection = this.getConnection();



            String query = "SELECT * FROM TEAMS WHERE DIVISION = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, division);

            resultSet = preparedStatement.executeQuery();
            if ((resultSet.next())) {

                String team = resultSet.getString("team");
                String team_city = resultSet.getString("team_city");
                String team_state = resultSet.getString("team_state");
                String conference = resultSet.getString("conference");
                int arena_ID = resultSet.getInt("arena_ID");

                teams = new Teams(team, team_city, team_state, team, conference, arena_ID);



            }
        } catch (SQLException e) {
            throw new DaoException("findTeamsByDivision() " + e.getMessage());
        }
        return teams;     // reference to User object, or null value

    }

    @Override
    public Teams insertTeam(String team, String team_city, String conference, String division, int arena_ID) throws DaoException {
        return null;
    }

    @Override
    public void deleteTeamByName(String team) throws DaoException {

    }
}
