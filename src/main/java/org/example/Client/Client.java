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
        {
            Scanner in = new Scanner(System.in);
            try {
                Socket socket = new Socket("localhost", 8080);  // connect to server socket
                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();

                Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

                BufferedReader bufferedReader = new BufferedReader(reader);
                Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                PlayerDaoInterface IPlayerDao = new MySqlPlayerDao();

                System.out.println("Client message: The Client is running and has connected to the server");
                System.out.println( "Please enter your choice" );
                System.out.println( "1. Find all players" );
                int choice = keyboard.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Find all players");
                        String sqlFindAllPlayers = "FIND_ALL_PLAYERS\n";
                        writer.write(sqlFindAllPlayers);
                        writer.flush();
                        String response = bufferedReader.readLine();
                        System.out.println(response);
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }

            } catch (IOException e) {
                System.out.println("Client message: IOException: "+e);
            }
        }
}

