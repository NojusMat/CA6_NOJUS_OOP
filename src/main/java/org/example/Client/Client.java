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
import java.util.List;
import java.util.Scanner;
import java.util.List;
import org.example.DAOsTest.*;
import org.example.DTOsTest.Player;
import org.example.Exceptions.DaoException;

import static java.lang.System.out;

public class Client 
{
    public static void main(String[] args)
    {

        Client client = new Client();
        client.start();
    }
    
    public void start()
    {

        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("10.108.2.76", 8080);  // connect to server socket
            OutputStream os = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);   // true => auto flush buffers
            Scanner inStream = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply

            Reader reader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(reader);
//            Gson gson = new G

            out.println("Client message: The Client is running and has connected to the server");

            out.println("WELCOME \n Select one of the following options by typing what is in the brackets:”");

            out.println("\nNBA MENU");               //menu options
            out.println("1.SEE ALL PLAYERS");
            out.println("2.FIND PLAYER");
            out.println("3.ADD PLAYER");
            out.println("4.DELETE");
            out.println("10.EXIT\n");
            String command = in.nextLine();



            if(command.startsWith("displayid"))   //we expect the server to return a time (in milliseconds)
            {
                out.println("Enter a players id: ");
                String id = in.nextLine();

                String commmand = "DISPLAY_PLAYER_BY_ID" + " " + id;

                socketWriter.write(command);  // write command to socket, and newline terminator
                socketWriter.flush();              // flush (force) the command over the socke

                // send request to server

            }
           else if(command.startsWith("displayall"))   //we expect the server to return a time (in milliseconds)
            {
                out.println("Display All Players");
               // List<Player> allPlayers = IPlayerDao.findAllPlayers();
               // for (Player player : allPlayers)
                 //   System.out.println("Player: " + player.toString());

            }
            else                            // the user has entered the Echo command or an invalidcommand
            {
                String input = inStream.nextLine();
                out.println("Client message: Response from server: \"" + input + "\"");
            }
            
            out.close();
            inStream.close();
            socket.close();
            
        } catch (IOException e) {
            out.println("Client message: IOException: "+e);
        }
    }
}


//  LocalTime time = LocalTime.parse(timeString); // Parse String -> convert to LocalTime object if required