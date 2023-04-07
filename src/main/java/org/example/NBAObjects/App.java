package org.example.NBAObjects;

import com.google.gson.Gson;
import org.example.DAOs.MySqlPlayerDao;
import org.example.DAOs.PlayerDaoInterface;
import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class App {

    public static void main(String[] args) throws DaoException {
        App app = new App();
        app.start();
    }

        public Player start() throws DaoException {
            Scanner keyboard = new Scanner(System.in);

            // Instantiate a Gson Parser
            // The GSon parser classes have been loaded by Maven based on a dependency in the pom.xml file.
            Gson gsonParser = new Gson();



            PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

            HashSet<Integer> cache = new HashSet<Integer>();     //hashset used for collecting the player ID

            try {
                cache = new HashSet<>();

                List<Player> players = IPlayerDao.findAllPlayers();
                for (Player player : players) {   // call a method in the DAO
                    cache.add(player.getId());    //adds players id to the cache
                }

                int choice;   // users menu choice
                int filterchoice;
                do {

                    System.out.println("\nNBA MENU");               //menu options
                    System.out.println("1.SEE ALL PLAYER");
                    System.out.println("2.FIND PLAYER");
                    System.out.println("3.ADD PLAYER");
                    System.out.println("4.DELETE PLAYER");
                    System.out.println("5.FILTERS");
                    System.out.println("6.CACHE");
                    System.out.println("7.JSON ALL PLAYERS");
                    System.out.println("8.JSON FIND PLAYER BY ID");
                    System.out.println("10.EXIT\n");

                    System.out.print("CHOICE:");


                    choice = keyboard.nextInt();

                    switch (choice) {

//-------------------------------FIND ALL USERS
                        case 1:
                            System.out.println("1.SEE ALL PLAYER");
                            try {
                                System.out.println("\nCall findAllPlayers()");

                                List<Player> allPlayers = IPlayerDao.findAllPlayers();     // call a method in the DAO

                                if (allPlayers.isEmpty())
                                    System.out.println("There are no Players");
                                else {
                                    for (Player player : allPlayers)
                                        System.out.println("Player: " + player.toString());
                                }
                            } catch (DaoException e) {
                                e.printStackTrace();
                            }
                            break;

                        //--------------------------------FIND PLAYER BY ID
                        case 2:
                            try {

                                System.out.print("Enter a players ID who you would like to find: ");


                                int findId = keyboard.nextInt();
                                Player player = IPlayerDao.findPlayerById(findId);

                                if (cache.contains(findId)) // null returned if userid and password not valid
                                    System.out.println("Player found: " + player);//display player

                                else {
                                    System.out.println("That player does not exist");
                                }

                            } catch (DaoException e) {
                                e.printStackTrace();
                            }

                            break;

                        //-----------------------ADD PLAYER-------
                        case 3:
                            try {

                                System.out.println("\nCall: addPlayer()");

                                System.out.println("Enter the Players First Name (string):");
                                String addFName = keyboard.next();
                                System.out.println("Enter the Players Last Name (string):");
                                String addLName = keyboard.next();
                                System.out.println("Enter the Players Team (string)");
                                String addTeam = keyboard.next();
                                System.out.println("Enter the Players Height in Cm (double):");
                                double addHeight = keyboard.nextDouble();
                                System.out.println("Enter the Players Points per Game(float):");
                                float addPPG = keyboard.nextFloat();
                                System.out.println("Enter the Players Weight in Kg (int):");
                                int addWeight = keyboard.nextInt();


                                IPlayerDao.insertPlayer(addFName, addLName, addTeam, addHeight, addPPG, addWeight);// adds the users chosen atributes to player
                                System.out.println("NEW PLAYER First Name:" + addFName + ",Last Name:" + addLName + ", Team:" + addTeam + ", Height:" + addHeight + ", Points per game:" + addPPG + ", Weight:" + addWeight);// displaying added player

                            } catch (DaoException e) {
                                e.printStackTrace();
                            }
                            break;
                        //------------------------------ DELETE PLAYER
                        case 4:
                            try {
                                System.out.println("\nCall: deletePlayerById()\n");

                                System.out.println("Enter a players ID who you would like to delete");
                                int DeleteId = keyboard.nextInt();


                                if (cache.contains(DeleteId)) // checking if the id exists
                                {
                                    IPlayerDao.deletePlayerById(DeleteId);              //deleting chosen player

                                    System.out.println("Player has been Deleted ");

                                }
                                else {
                                    System.out.println("Player with this ID does not exist");
                                }
                            } catch (DaoException e) {
                                e.printStackTrace();
                            }
                            break;
                        //------------------------------ FILTER
                        case 5:
                            do {
                                System.out.println("\nFILTER MENU");
                                System.out.println("1.FILTER BY HEIGHT");
                                System.out.println("10.EXIT\n");

                                System.out.print("CHOICE:");


                                filterchoice = keyboard.nextInt();
                                switch (filterchoice) {
                                    case 1:
                                        System.out.println("HEIGHT IN ASCENDING ORDER");
                                        List<Player> filterPlayers = IPlayerDao.findAllPlayers();  // displaying all players
                                        Collections.sort(filterPlayers);                            //adding a sort of height

                                        System.out.println("\ncarList ArrayList after Collections.sort( carList )");
                                        for (Player player : filterPlayers)
                                            System.out.println(player);


                                        break;

                                }

                            }
                            while (filterchoice != 10);

                            break;

                        //------------------------------ CACHE
                        case 6:
                            try {

                                System.out.println("\nCall: Cache()\n");
                                System.out.println("\nPlayer IDS in cache" + cache + "\n");// showing what is in cache




                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        //------------------------------ JSON ALL PLAYERS
                        case 7:
                            try {

                                System.out.println("\nCall: JSON ALL PLAYERS()\n");

                                String findAllPlayersJson = IPlayerDao.findAllPlayersJson();



                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }


                            break;
                        //------------------------------ JSON FIND PLAYER BY ID
                        case 8:
                            try {

                                System.out.println("\nCall: FIND PLAYER BY ID()\n");




                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }


                            break;
                        //------------------------------ EXIT PROGRAM
                        case 10:
                            System.out.println("EXITING");
                            break;

                        default:
                            System.out.println("Invalid Choice.Please try again");
                            break;
                    }
                    System.out.println("\n");
                } while (choice != 10);
                return null;
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }
        }
}


