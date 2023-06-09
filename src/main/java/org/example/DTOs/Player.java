package org.example.DTOs;

import java.util.Objects;
import java.util.Set;

public class Player implements Comparable<Player> {

    private int id;  //declaring veriables

    private Set<Integer> cache;
    private String firstName;
    private String lastName;
    private String team;
    private double height_in_Cm;

    private int weight_in_Kg ;
    private float points_Per_Game;


    public Player(int id, String firstName, String lastName,String team, double height_in_Cm, int weight_in_Kg,float points_Per_Game)
    {
        this.id = id;                       // constructor player class
        this.firstName = firstName;
        this.lastName = lastName;
        this.team=team;
        this.height_in_Cm = height_in_Cm;
        this.weight_in_Kg = weight_in_Kg;
        this.points_Per_Game = points_Per_Game;
    }


    public int getId()
    {
        return id;
    }       //setters and getters

    public void setId(int id)
    {
        this.id = id;
    }


    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }



    public double getHeight_in_Cm()
    {
        return height_in_Cm;
    }

    public void setHeight_in_Cm(double height_in_Cm)
    {
        this.height_in_Cm = height_in_Cm;
    }



    public int getWeight_in_Kg() {return weight_in_Kg;}

    public void setWeight_in_Kg(int weight_in_Kg) {this.weight_in_Kg = weight_in_Kg;}



    public float getPoints_Per_Game() {return points_Per_Game;}

    public void setPoints_Per_Game(float points_Per_Game) {this.points_Per_Game = points_Per_Game;}

//    public void displayPlayer()
//    {
//        String leftAlignFormat = "| %-14i| %-14s| %-14s| %-14s| %-14i| %-14f| %-14d|%n";
//        System.out.format( leftAlignFormat, id, firstName, lastName, team, height_in_Cm,weight_in_Kg,points_Per_Game);
//
//    }



    @Override
    public String toString()
    {

        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        return "[" + "ID=" + id + ",| First Name=" + firstName + ",| Last Name=" + lastName+",| Team=" + team + ",| Height in Cm=" + height_in_Cm +",| Weight in  Kg=" +weight_in_Kg+ ",| Points Per Game=" + points_Per_Game+']';
    }


    @Override
    public int hashCode()       //hashcode for player attributes
    {
        return Objects.hash(id, firstName, lastName, team, height_in_Cm,weight_in_Kg,points_Per_Game);
    }

    @Override
    public int compareTo(Player otherPlayer)
    {
        if( this.height_in_Cm < otherPlayer.height_in_Cm )        // will result in ascending order
            return -1;
        else if( this.height_in_Cm == otherPlayer.height_in_Cm)
            return 0;
        else
            return 1;
    }

}

