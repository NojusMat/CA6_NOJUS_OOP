package org.example.NBAObjects;

import org.example.DAOs.MySqlPlayerDao;
import org.example.DAOs.PlayerDaoInterface;
import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import java.util.List;



public class App {
    public static void main(String[] args)
    {
        Player IPlayerDao = new MySqlPlayerDao();  //"IUserDao" -> "I" stands for for


//-------------------------------FIND ALL USERS
        try
        {
            System.out.println("\nCall findAllPlayers()");
            List<Player> players = IPlayerDao.findAllPlayers();     // call a method in the DAO

            if( players.isEmpty() )
                System.out.println("There are no Players");
            else {
                for (Player player : players)
                    System.out.println("Player: " + player.toString());
            }
        }


        catch( DaoException e )
        {
            e.printStackTrace();
        }
    }
}
