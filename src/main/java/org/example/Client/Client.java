/** CLIENT                                                  February 2021
 *
 * This Client program asks the user to input commands to be sent to the server.
 *
 * There are only two valid commands in the protocol: "Time" and "Echo"
 *
 * If user types "Time" the server should reply with the current server time.
 *
 * If the user types "Echo" followed by a message, the server will echo back the message.
 * e.g. "Echo Nice to meet you"
 *
 * If the user enters any other input, the server will not understand, and
 * will send back a message to the effect.
 *
 * NOte: You must run the server before running this the client.
 * (Both the server and the client will be running together on this computer)
 */
package org.example.Client;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.DAOsTest.*;
import org.example.DTOsTest.Player;
import org.example.Exceptions.DaoException;

import static java.lang.System.out;

public class Client{

        private static final Scanner keyboard = new Scanner(System.in);

        public static void main(String[] args)
        {
            Client client = new Client();
            client.start();
        }

        public void start()
        {Scanner in = new Scanner(System.in);
            Gson gson = new Gson();
            try {
                Socket socket = new Socket("localhost", 8078);  // connect to server socket

                System.out.println("Client message: The Client is running and has connected to the server");

                System.out.println( "Please enter your choice" );
                System.out.println( "1. FIND_ALL_PLAYERS" );
                System.out.println( "2. FIND_PLAYER_BY_ID" );
                System.out.println( "3. Delete players" );
                System.out.println( "4. ADD_PLAYER" );
                String choice = in.nextLine();

                OutputStream os = socket.getOutputStream();
                PrintWriter socketWriter = new PrintWriter(os, true);

//
                socketWriter.flush();              // flush (force) the command over the socket


                Scanner inStream = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply
                // wait for, and retrieve the reply
                if(choice.startsWith("FIND_ALL_PLAYERS"))   //we expect the server to return a time
                {
                    String command ="FIND_ALL_PLAYERS";
                    socketWriter.write(command+"\n");// write command to socket, and newline terminator
                    socketWriter.flush();// flush (force) the command over the socket
                    String input = inStream.nextLine();
//                    System.out.println("Client message: Response from server: \"" + input + "\"");
                    System.out.println("DISPLAYING ALL PLAYERS:");
                    Type playerListType = new TypeToken<List<Player>>(){}.getType();
                    List<Player> playerList = gson.fromJson(input, playerListType);
//
                    // Display object
                    out.println("Print the players from the List of Players :");
                    for (Player player : playerList) {
                        System.out.println(player.toString());

                    }
                } else if (choice.startsWith("FIND_PLAYER_BY_ID")) {
                    System.out.println("Enter a players ID:");
                    int findId = keyboard.nextInt();

                    String command = "FIND_PLAYER_BY_ID" + " " + findId;
                    socketWriter.write(command + "\n");// write command to socket, and newline terminator
                    socketWriter.flush();// flush (force) the command over the socket
                    String response = inStream.nextLine();
                    Player player = gson.fromJson(response, Player.class);

                    if (player == null) {
                        System.out.println("Player with the ID:" + findId + " does not exist");
                    } else {

                        System.out.println(" Find Player with id:" + findId);
                        System.out.println(player.toString());
                    }
                }
                     else if (choice.startsWith("ADD_PLAYER")) {
                        System.out.println("Adding a player:");
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

                    String command ="ADD_PLAYER" + " "+ addFName+ " "+ addLName+ " "+ addTeam+ " "+ addHeight+ " "+ addPPG+ " "+ addWeight;
                        socketWriter.write(command+"\n");// write command to socket, and newline terminator
                        socketWriter.flush();// flush (force) the command over the socket
                        String response = inStream.nextLine();
                        Player player = gson.fromJson(response,Player.class);

                        if(player == null){
                            System.out.println("That player dosnt exist");
                        }
                        else{

                            System.out.println("NEW PLAYER First Name:" + addFName + ",Last Name:" + addLName + ", Team:" + addTeam + ", Height:" + addHeight + ", Points per game:" + addPPG + ", Weight:" + addWeight);// displaying added player
                            System.out.println(player.toString());
                        }

                }

                out.close();
                inStream.close();
                socket.close();

            } catch (IOException e) {
                System.out.println("Client message: IOException: "+e);
            }
        }
}


