package org.example.NBAObjectsTest;

import com.google.gson.Gson;
import org.example.DAOsTest.*;
import org.example.DTOsTest.Arena;
import org.example.DTOsTest.Player;
import org.example.DTOsTest.Teams;
import org.example.Exceptions.DaoException;

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

            TeamsDaoInterface ITeamsDao = new MySqlTeamsDao();
            ArenaDaoInterface IArenaDao = new MySqlArenaDao();

            HashSet<Integer> cache = new HashSet<Integer>();     //hashset used for collecting the player ID
                HashSet<Integer> cacheArena = new HashSet<Integer>();
            try {
                cache = new HashSet<>();

                List<Player> players = IPlayerDao.findAllPlayers();
                for (Player player : players) {   // call a method in the DAO
                    cache.add(player.getId());    //adds players id to the cache
                }

                 List<Arena> arenas =IArenaDao.findAllArenas();
                for(Arena arena:arenas){
                      cacheArena.add(arena.getArena_ID());
                }


                int choice;   // users menu choice
                int filterchoice;
                do {

                    System.out.println("\nNBA MENU");               //menu options
                    System.out.println("1.SEE ALL INFORMATION");
                    System.out.println("2.FIND ");
                    System.out.println("3.ADD");
                    System.out.println("4.DELETE");
                    System.out.println("5.FILTERS/SORT");
                    System.out.println("6.CACHE");
                    System.out.println("7.JSON ALL PLAYERS");
                    System.out.println("8.JSON FIND PLAYER BY ID");
                    System.out.println("10.EXIT\n");

                    System.out.print("CHOICE:");


                    choice = keyboard.nextInt();

                    switch (choice) {

//-------------------------------FIND ALL USERS
                        case 1:
                            do {
                                System.out.println("\nSEE ALL INFORMATION ON:");
                                System.out.println("1.PLAYERS");
                                System.out.println("2.TEAMS");
                                System.out.println("3.ARENAS");
                                System.out.println("10.EXIT\n");

                                System.out.print("CHOICE:");




                                filterchoice = keyboard.nextInt();
                                switch (filterchoice) {
                                    case 1:

                                        try {
                                            System.out.println("\nFind PLAYERS");
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
                                    case 2:
                                        System.out.println("\nALL TEAMS");
                                        List<Teams> findAllTeams =ITeamsDao.findAllTeams();
                                        for (Teams team : findAllTeams)
                                            System.out.println("Team: " + team.toString());

                                        break;

                                case 3:
                                    System.out.println("\nALL ARENAS");
                                    List<Arena> findAllArenas =IArenaDao.findAllArenas();
                                    for (Arena arena : findAllArenas)
                                        System.out.println("Arena: " + arena.toString());

                                    break;
                            }

                            }
                            while (filterchoice != 10);
                            break;

                        //--------------------------------FIND
                        case 2:
                            do {
                                System.out.println("\nFIND INFORMATION USING THE FOLLOWING:");
                                System.out.println("1.PLAYERS BY ID");
                                System.out.println("2.TEAMS BY DIVISION");
                                System.out.println("3.USING ARENA ID FIND TEAM");
                                System.out.println("10.EXIT\n");

                                System.out.print("CHOICE:");

                                filterchoice = keyboard.nextInt();
                                switch (filterchoice) {
                                    case 1:

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
                                    case 2:
                                        System.out.print("Enter a teams City who you would like to find: ");
                                        String findTeamCity = keyboard.next();
                                        Teams teams = ITeamsDao.findTeamsByCity(findTeamCity);

                                        if(teams !=null)
                                        System.out.println("Team in the city of "+findTeamCity+": " + teams);//display player
                                        else {
                                            System.out.println("No Teams in this city of:"+findTeamCity);

                                        }


                                        break;

                                    case 3:
                                        System.out.print("Enter Arena ID to display what team plays in it : ");
                                        int findByArenaID = keyboard.nextInt();
                                        String teamArena = IArenaDao.findTeamsByArena(findByArenaID);

                                        if(teamArena !=null)
                                            System.out.println("Team with the arena id "+findByArenaID+": " + teamArena);//display player
                                        else {
                                            System.out.println("No Teams plays in a arena with the arena code:"+findByArenaID);

                                        }


                                        break;
                                }

                            }
                            while (filterchoice != 10);

                            break;

                        //-----------------------ADD -------
                        case 3:

                            do {
                                System.out.println("\nADD:");
                                System.out.println("1.PLAYER");
                                System.out.println("2.TEAM");
                                System.out.println("3.ARENA");
                                System.out.println("10.EXIT\n");

                                System.out.print("CHOICE:");




                                filterchoice = keyboard.nextInt();
                                switch (filterchoice) {
                                    case 1:

                                        try {

                                            System.out.println("\nCall: ADD PLAYER()");
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
                                    case 2:
                                        try {

                                            System.out.println("\nCall: ADD TEAM()");
                                            System.out.println("Enter the Team Name (string):");
                                            String addTeamName = keyboard.next();
                                            System.out.println("Enter the Team City (string):");
                                            String addTeamCity = keyboard.next();
                                            System.out.println("Enter the Conference (string)");
                                            String addConference = keyboard.next();
                                            System.out.println("Enter the Division (string):");
                                            String addDivision = keyboard.next();
                                            System.out.println("Enter the Arena ID (int):");
                                            int ArenaID = keyboard.nextInt();

                                            ITeamsDao.insertTeam(addTeamName, addTeamCity, addConference, addDivision, ArenaID);// adds the users chosen atributes to player
                                            System.out.println("NEW Team: Team Name:" + addTeamName + ",Team City:" + addTeamCity + ", Conference:" + addConference + ", Division:" + addDivision + ", Arena ID:" + ArenaID);// displaying added player


                                        } catch (DaoException e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    case 3:
                                        try {
                                            System.out.println("\nCall: ADD ARENA()");
                                            System.out.println("Enter the Arena ID (int):");
                                            int addArenaid = keyboard.nextInt();
                                            System.out.println("Enter the Arena name (string):");
                                            String addArenaName = keyboard.next();
                                            System.out.println("Enter the Capacity (int)");
                                            int addArenaCapacity = keyboard.nextInt();

                                            IArenaDao.insertArena(addArenaid, addArenaName, addArenaCapacity);
                                            System.out.println("NEW Arena: Arena ID:" + addArenaid + ",Arena Name:" + addArenaName + ", Arena Capacity:" +addArenaCapacity);


                                        } catch (DaoException e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                }

                            }
                            while (filterchoice != 10);

                            break;
                        //------------------------------ DELETE
                        case 4:

                            do {
                                System.out.println("\nDELETE:");
                                System.out.println("1.PLAYER");
                                System.out.println("2.TEAM");
                                System.out.println("3.ARENA");
                                System.out.println("10.EXIT\n");

                                System.out.print("CHOICE:");




                                filterchoice = keyboard.nextInt();
                                switch (filterchoice) {
                                    case 1:

                                        try {
                                            System.out.println("\nCall: DELETE PLAYER\n");

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
                                    case 2:
                                        try {
                                            System.out.println("\nCall: DELETE TEAM \n");

                                            System.out.println("Enter the team name youd like to delete");
                                            String DeleteId = keyboard.next();
                                            ITeamsDao.deleteTeamByName(DeleteId);              //deleting chosen player
                                            System.out.println("Team has been Deleted ");

                                } catch (DaoException e) {
                                    e.printStackTrace();
                                }
                                        break;
                                    case 3:

                                        try {
                                            System.out.println("\nCall: DELETE ARENA\n");

                                            System.out.println("Enter a ARENA ID that you would like to delete");
                                            int DeleteId = keyboard.nextInt();


                                            if (cacheArena.contains(DeleteId)) // checking if the id exists
                                            {
                                                IArenaDao.deleteArenaByArenaID(DeleteId);              //deleting chosen player

                                                System.out.println("Arena has been Deleted ");

                                            }
                                            else {
                                                System.out.println("Arena with this ID does not exist");
                                            }
                                        } catch (DaoException e) {
                                            e.printStackTrace();
                                        }

                                        break;
                                }

                            }
                            while (filterchoice != 10);

                            break;
                        //------------------------------ FILTER
                        case 5:


                            do {
                                System.out.println("\nFILTER MENU");
                                System.out.println("1.FILTER BY HEIGHT");
                                System.out.println("2.SORT BY CAPACITY");
                                System.out.println("10.EXIT\n");

                                System.out.print("CHOICE:");


                                filterchoice = keyboard.nextInt();
                                switch (filterchoice) {
                                    case 1:

                                        System.out.println("HEIGHT IN ASCENDING ORDER");
                                        List<Player> filterPlayers = IPlayerDao.findAllPlayers();  // displaying all players
                                        Collections.sort(filterPlayers);                            //adding a sort of height

                                        System.out.println("\nPlayerList ArrayList after Collections.sort( Player List )");
                                        for (Player player : filterPlayers)
                                            System.out.println(player);

                                        break;
                                    case 2:

                                            System.out.println("\nSORT BY CAPACITY  (DESCENDING) \n");

                                        List<Arena> filterArenaCapacity = IArenaDao.findAllArenas();  // displaying all players
                                        Collections.sort(filterArenaCapacity);                            //adding a sort of height

                                        System.out.println("\nArena sorted using capacity )");
                                        for (Arena arena : filterArenaCapacity)
                                            System.out.println(arena);

                                        break;
                                }

                            }
                            while (filterchoice != 10);

                            break;
                        //------------------------------ CACHE
                        case 6:
                            try {

                                System.out.println("\nCall: Cache()\n");
                                System.out.println("\nPlayer IDS in cache" + cache);// showing what is in cache
                                      System.out.println("\nArenas IDS in cache" + cacheArena + "\n");



                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        //------------------------------ JSON ALL PLAYERS
                        case 7:
                            try {

                                System.out.println("\nCall: JSON ALL PLAYERS()\n");

                                IPlayerDao.findAllPlayersJson();



                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }


                            break;
                        //------------------------------ JSON FIND PLAYER BY ID
                        case 8:
                            try {
                                System.out.println("\nCall: FIND PLAYER BY ID()\n");
                                System.out.print("Enter a players ID who you would like to find: ");
                                int findIdjson = keyboard.nextInt();


                                if (cache.contains(findIdjson)) // null returned if userid and password not valid
                                    System.out.println(IPlayerDao.findPlayerByIdJson(findIdjson));

                                else {
                                    System.out.println("That player does not exist");
                                }


                            } catch (DaoException e) {
                                e.printStackTrace();
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


