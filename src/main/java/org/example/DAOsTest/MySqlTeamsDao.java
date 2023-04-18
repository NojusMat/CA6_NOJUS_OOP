package org.example.DAOsTest;

import org.example.DTOsTest.Teams;
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
    public Teams findTeamsByCity(String team_city) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Teams teams = null;
        try {
            connection = this.getConnection();



            String query = "SELECT * FROM TEAMS WHERE team_city = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, team_city);

            resultSet = preparedStatement.executeQuery();
            if ((resultSet.next())) {

                String team = resultSet.getString("team");
                String team_state = resultSet.getString("team_state");
                String conference = resultSet.getString("conference");
                String division = resultSet.getString("division");
                int arena_ID = resultSet.getInt("arena_ID");

                teams = new Teams(team, team_state, team, conference,division, arena_ID);



            }
        } catch (SQLException e) {
            throw new DaoException("findTeamsByCity() " + e.getMessage());
        }
        return teams;     // reference to User object, or null value

    }

    @Override
    public Teams insertTeam(String team, String team_city, String conference, String division, int arena_ID) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Teams teams = null;

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "INSERT INTO TEAMS (team,team_city,conference,division,arena_ID) VALUES ( ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query);

            ps.setString(1, team);
            ps.setString(2, team_city);
            ps.setString(3, conference);
            ps.setString(4, division);
            ps.setFloat(5, arena_ID);

            ps.executeUpdate();

        }


        // Execute the Prepared Statement and get a result set
        catch (SQLException e) {
            throw new DaoException("insertTeam() " + e.getMessage());
        }
        return teams;     // reference to User object, or null value
    }

    @Override
    public void deleteTeamByName(String team) throws DaoException {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            connection = this.getConnection();

            String query = "DELETE FROM TEAMS WHERE team = ?";
            ps = connection.prepareStatement(query);

            ps.setString(1, team);
//            resultSet = ps.executeQuery();

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("deleteTeamByName() " + e.getMessage());
        }
    }


}
