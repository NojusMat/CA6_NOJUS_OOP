package org.example.DAOs;

import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySqlPlayerDao extends MySqlDao implements PlayerDaoInterface {
    @Override
    public List<Player> findAllPlayers() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Player> playersList = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("PLAYER_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String team = resultSet.getString("TEAM");
                double height_in_Cm = resultSet.getDouble("HEIGHT_IN_CM");
                int weight_in_Kg = resultSet.getInt("WEIGHT_IN_KG");
                float points_Per_Game = resultSet.getFloat("POINTS_PER_GAME");



                Player p = new Player(id, firstName, lastName, team, height_in_Cm,weight_in_Kg,points_Per_Game);
                playersList.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllPlayerresultSet() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllPlayers() " + e.getMessage());
            }
        }
        return playersList;     // may be empty
    }

    @Override
    public Player findPlayerById(int  id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Player player = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER WHERE ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {

                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String team = resultSet.getString("TEAM");
                double height_in_Cm = resultSet.getDouble("HEIGHT_IN_CM");
                int weight_in_Kg = resultSet.getInt("WEIGHT_IN_KG");
                float points_Per_Game = resultSet.getFloat("POINTS_PER_GAME");


                player = new Player(id, firstName, lastName, team, height_in_Cm,weight_in_Kg,points_Per_Game);

            }
        } catch (SQLException e)
        {
            throw new DaoException("findPlayerById() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findPlayerById() " + e.getMessage());
            }
        }
        return player;     // reference to User object, or null value
    }

    @Override
    public void addPlayer() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Player player = null;

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "INSERT INTO PLAYER (ID,FIRST_NAME,LAST_NAME,TEAM,HEIGHT_IN_CM,WEIGHT_IN_KG,POINTS_PER_GAME) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query);

            int id =16;
            String firstName = "Tom";
            String lastName = "Silver";
            String team = "Portland Trail Blazers";
            double height_in_Cm = 175.14;
            float points_Per_Game= 43.02; //This needs to be changed
            int weight_in_Kg =100;

            ps.setInt( 1, id);
            ps.setString( 2, firstName);
            ps.setString( 3, lastName);
            ps.setString( 4, team);
            ps.setDouble( 5, height_in_Cm);
            ps.setFloat( 6, points_Per_Game);
            ps.setInt( 7, weight_in_Kg);

            ps.executeUpdate();




            // Execute the Prepared Statement and get a result set

        }

        catch (SQLException e)
        {
            throw new DaoException("addPlayer" + e.getMessage());
        }
    }

}
