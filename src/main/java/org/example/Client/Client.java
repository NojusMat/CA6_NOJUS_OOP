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

            try {
                Socket socket = new Socket("localhost", 8080);  // connect to server socket

                System.out.println("Client message: The Client is running and has connected to the server");

                System.out.println("Please enter a command:FIND_ALL_PLAYERS \n>");
                String command = in.nextLine();

                OutputStream os = socket.getOutputStream();
                PrintWriter out = new PrintWriter(os, true);

                out.write(command+"\n");  // write command to socket, and newline terminator
                out.flush();              // flush (force) the command over the socket

                Scanner inStream = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply
                // wait for, and retrieve the reply
                if(command.startsWith("FIND_ALL_PLAYERS"))   //we expect the server to return a time
                {

                    String input = inStream.nextLine();
//                    System.out.println("Client message: Response from server: \"" + input + "\"");
                    System.out.println("DISPLAYING ALL PLAYERS:");
                    Type playerListType = new TypeToken<List<Player>>(){}.getType();
                    Gson gson = new Gson();
                    List<Player> playerList = gson.fromJson(input, playerListType);
//
                    // Display object
                    out.println("Print the players from the List of Players :");
                    for (Player player : playerList) {
                        System.out.println(player.toString());

                    }
                }
                else                            // the user has entered the Echo command or an invalid command
                {

                }

                out.close();
                inStream.close();
                socket.close();

            } catch (IOException e) {
                System.out.println("Client message: IOException: "+e);
            }
        }
}


