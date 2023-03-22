package org.example.DTOs;


public class Player {

    private int id;
    private String firstName;
    private String lastName;
    private String team;
    private double height_in_Cm;
    private float points_Per_Game;
    private int weight_in_Kg ;


    public Player(int id, String firstName, String lastName,String team, double height_in_Cm, float points_Per_Game, int weight_in_Kg)
    {
        this.id = id;
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
    }

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


    public float getPoints_Per_Game() {return points_Per_Game;}

    public void setPoints_Per_Game(float points_Per_Game) {this.points_Per_Game = points_Per_Game;}


    public int getWeight_in_Kg() {return weight_in_Kg;}

    public void setWeight_in_Kg(int weight_in_Kg) {this.weight_in_Kg = weight_in_Kg;}



    @Override
    public String toString()
    {
        return "Player{" + "ID=" + id + ", First Name=" + firstName + ", Last Name=" +", Team=" + team +
                lastName + ", Height in Cm=" + height_in_Cm +", Weight in  Kg=" +weight_in_Kg+ ", Points Per Game=" + points_Per_Game+'}';
    }

}
