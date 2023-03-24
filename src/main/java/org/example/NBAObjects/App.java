package org.example.NBAObjects;

import java.sql.*;
import org.example.DAOs.MySqlPlayerDao;
import org.example.DAOs.PlayerDaoInterface;
import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import java.util.List;
import java.util.Scanner;



public class App {
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

        public void start() {
            Scanner keyboard = new Scanner(System.in);

            PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

//-------------------------------FIND ALL USERS
            try {
                System.out.println("\nCall findAllPlayers()");
                List<Player> players = IPlayerDao.findAllPlayers();     // call a method in the DAO

                if (players.isEmpty())
                    System.out.println("There are no Players");
                else {
                    for (Player player : players)
                        System.out.println("Player: " + player.toString());
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }


            //--------------------------------FIND PLAYER BY ID
            try {
                System.out.println("\nCall: findPlayerById()");
                int id = 15;
                Player player = IPlayerDao.findPlayerById(id);

                if (player != null) // null returned if userid and password not valid
                    System.out.println("Player found: " + player);
                else
                    System.out.println("Player with that id was not found");

            } catch (DaoException e) {
                e.printStackTrace();
            }

            //-----------------------ADD PLAYER-------

//            try {
//                System.out.println("\nCall: addPlayer()");
//                IPlayerDao.addPlayer();
//
//
//                System.out.println("Player has been added ");
//
//            }
//            catch( DaoException e )
//            {
//                e.printStackTrace();
//            }
            //------------------------------ DELETE PLAYER

            try {
                System.out.println("\nCall: deletePlayerById()\n");

                System.out.println("Enter a players ID who you would like to delete");
                int DeleteId = keyboard.nextInt();
                IPlayerDao.deletePlayerById(DeleteId);

                System.out.println("Player has been Deleted ");

            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
}
