package org.example.NBAObjects;

import org.example.DAOs.MySqlPlayerDao;
import org.example.DAOs.PlayerDaoInterface;
import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;
import java.util.*;


public class App {
    public static void main(String[] args) throws DaoException {
        App app = new App();
        app.start();
    }

        public void start() throws DaoException {
            Scanner keyboard = new Scanner(System.in);




            PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();


            int choice;
            int filterchoice;
            do{
                IPlayerDao.checkIdExists(1);
                System.out.println("\n");

                System.out.println("\nNBA MENU");
                System.out.println("1.SEE ALL PLAYER");
                System.out.println("2.FIND PLAYER");
                System.out.println("3.ADD PLAYER");
                System.out.println("4.DELETE PLAYER");
                System.out.println("5.FILTERS");
                System.out.println("10.EXIT\n");

                System.out.print("CHOICE:");


                choice = keyboard.nextInt();

                switch (choice) {

//-------------------------------FIND ALL USERS
                    case 1:
                        System.out.println("1.SEE ALL PLAYER");
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
                    break;

                    //--------------------------------FIND PLAYER BY ID
                    case 2:
                    try {
                        System.out.println("\nCall: findPlayerById()");
                        System.out.print("Enter a players ID who you would like to find: ");
                        int findId = keyboard.nextInt();
                        Player player = IPlayerDao.findPlayerById(findId);

                        if (player != null) // null returned if userid and password not valid
                            System.out.println("Player found: " + player);
                        else
                            System.out.println("Player with that ID was not found");

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


                        IPlayerDao.insertPlayer(addFName, addLName, addTeam, addHeight, addPPG, addWeight);
                        System.out.println("NEW PLAYER First Name:"+addFName+",Last Name:"+addLName+", Team:"+addTeam+", Height:"+addHeight+", Points per game:"+addPPG+", Weight:"+addWeight);

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
                        IPlayerDao.deletePlayerById(DeleteId);


                        System.out.println("Player has been Deleted ");

                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                        break;
                    //------------------------------ FILTER
                    case 5:
                        do{
                            System.out.println("\nFILTER MENU");
                            System.out.println("1.FILTER BY HEIGHT");
                            System.out.println("10.EXIT\n");

                            System.out.print("CHOICE:");


                            filterchoice = keyboard.nextInt();
                            switch (filterchoice) {
                                case 1:
                                    System.out.println("HEIGHT IN ASCENDING ORDER");
                                    List<Player> players = IPlayerDao.findAllPlayers();
                                    Collections.sort(players);

                                    System.out.println("\ncarList ArrayList after Collections.sort( carList )");
                                    for( Player player : players )
                                        System.out.println( player );


                                    break;

                            }

                            }while(filterchoice!=10);


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
        }while(choice!=10);
    }
    }
