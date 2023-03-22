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
                float points_Per_Game = resultSet.getFloat("POINTS_PER_GAME");
                int weight_in_Kg = resultSet.getInt("WEIGHT_IN_KG");


                Player p = new Player(id, firstName, lastName, team, height_in_Cm, points_Per_Game,weight_in_Kg);
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
}
