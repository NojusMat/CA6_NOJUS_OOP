package org.example.DTOs;

public class Teams {


    private String team;
    private String team_city;
    private String team_state;
    private String conference;
    private String division;
    private int arena_ID;

    public Teams(String team, String team_city, String team_state, String conference, String division, int arena_ID) {
        this.team = team;
        this.team_city = team_city;         // constructor teams class
        this.team_state = team_state;
        this.conference = conference;
        this.division = division;
        this.arena_ID = arena_ID;

    }

    public String getTeam() {   // setters and getters for the teams class
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    public String getTeam_city() {
        return team_city;
    }

    public void setTeam_city(String team_city) {
        this.team_city = team_city;
    }


    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }


    public String getTeam_state() {
        return team_state;
    }

    public void setTeam_state(String team_state) {
        this.team_state = team_state;
    }


    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }


    public int getArena_ID() {
        return arena_ID;
    }

    public void setArena_ID(int arena_ID) {
        this.arena_ID = arena_ID;
    }  // do you set from a child class a primary of a parent class?

    @Override
    public String toString() { // to string method to display team

        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        return "Team[" + "Team name=" + team + ", City=" + team_city +
                ", Conference=" + conference + " State=" + team_state + " Division=" + division + " Arena ID=" + arena_ID + "]";
    }
}
