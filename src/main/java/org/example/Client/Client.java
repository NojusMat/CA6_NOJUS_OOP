/**
 * CLIENT
 * NOte: You must run the server before running this the client.
 * (Both the server and the client will be running together on this computer)
 */
package org.example.Client;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.example.DTOs.Player;
import org.example.Exceptions.DaoException;

import static java.lang.System.out;

public class Client {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        Gson gson = new Gson();
        try {
            Socket socket = new Socket("localhost", 8078);  // connect to server socket


            System.out.println("Client message: The Client is running and has connected to the server");


            int choice;   // users menu choice
            int filterchoice;
            do {
                System.out.println("───────────────────────────────");
                System.out.println("        NBA MENU     ");
                System.out.println("───────────────────────────────");
                System.out.println("Please enter your choice");
                System.out.println("1. FIND_ALL_PLAYERS");
                System.out.println("2. FIND_PLAYER_BY_ID");
                System.out.println("3. ADD_PLAYER");
                System.out.println("4. DELETE_PLAYER");
                System.out.println("5. EXIT");
                System.out.println("───────────────────────────────");
                System.out.print("CHOICE:");
                choice = keyboard.nextInt();
                out.println("\n");


                OutputStream os = socket.getOutputStream();
                PrintWriter socketWriter = new PrintWriter(os, true);

                socketWriter.flush();              // flush (force) the command over the socket

                //we expect the server to return a time
                Scanner inStream = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply
                switch (choice) {
                    case 1:

                        try {

                            String command = "FIND_ALL_PLAYERS";
                            socketWriter.write(command + "\n");// write command to socket, and newline terminator
                            socketWriter.flush();// flush (force) the command over the socket
                            String input = inStream.nextLine();
                            System.out.println("DISPLAYING ALL PLAYERS:");
                            Type playerListType = new TypeToken<List<Player>>() {
                            }.getType();
                            List<Player> playerList = gson.fromJson(input, playerListType);

                            // Display object
                            out.println("Print the players from the List of Players :");
                            for (Player player : playerList) {
                                System.out.println(player.toString());

                            }
                        } catch (JsonSyntaxException e) {
                            throw new RuntimeException(e);
                        }

                        break;
                    case 2:
                        System.out.print("Enter a players ID:");
                        int findId = keyboard.nextInt();

                        String command = "FIND_PLAYER_BY_ID" + " " + findId;
                        socketWriter.write(command + "\n");// write command to socket, and newline terminator
                        socketWriter.flush();// flush (force) the command over the socket
                        String response = inStream.nextLine();
                        Player player = null;
                        try{
                            player = gson.fromJson(response, Player.class);

                        }catch (JsonSyntaxException e){ // catching invalid responses
                            out.println("Invalid Response try again");
                        }

                        if (player == null) {
                            System.out.println("Player with the ID:" + findId + " does not exist");
                        } else {

                            System.out.println(" Find Player with id:" + findId);
                            System.out.println(player);
                        }
                        break;


                    case 3:
                        System.out.println("Adding a player:");
                        System.out.println("\nCall: ADD PLAYER()");
                        System.out.print("Enter the Players First Name (string):");
                        String addFName = keyboard.next();
                        System.out.print("Enter the Players Last Name (string):");
                        String addLName = keyboard.next();

                        System.out.print("Enter the Players Team (string) please user '_' for spaces");
                        String addTeam = keyboard.next();

                        System.out.print("Enter the Players Height in Cm (double):");
                        double addHeight = keyboard.nextDouble();

                        System.out.print("Enter the Players Points per Game(float):");
                        float addPPG = keyboard.nextFloat();

                        System.out.print("Enter the Players Weight in Kg (int):");
                        int addWeight = keyboard.nextInt();

                        command = "ADD_PLAYER" + " " + addFName + " " + addLName + " " + addTeam + " " + addHeight + " " + addPPG + " " + addWeight;
                        socketWriter.write(command + "\n");// write command to socket, and newline terminator
                        socketWriter.flush();// flush (force) the command over the socket
                        response = inStream.next();
                        System.out.println(response);// displaying added player
                        System.out.println("NEW PLAYER: First Name:" + addFName + ",Last Name:" + addLName + ", Team:" + addTeam + ", Height:" + addHeight + ", Points per game:" + addPPG + ", Weight:" + addWeight);// displaying added player

                        break;

                    case 4:

                        System.out.print("\nEnter a players ID you would like to delete:");
                        int deleteByID = keyboard.nextInt();

                        command = "DELETE_PLAYER" + " " + deleteByID;
                        socketWriter.write(command + "\n");// write command to socket, and newline terminator
                        socketWriter.flush();// flush (force) the command over the socket
                        response = inStream.nextLine();
                        out.println(response);
                        break;
                    case 5:
                        out.println("GoodBye");
                        out.close();
                        inStream.close();
                        socket.close();
                        break;

                    default:
                        out.println("Invalid Choice enter a different one ");
                        break;
                }
                out.println("\n");
            } while (choice != 5);
        } catch (IOException e) {
            System.out.println("Client message: IOException: " + e);
        }
    }
}


