package org.example.DTOs;

public class Arena {
    private int arena_ID;
    private String arena_name;
    private String city;
    private String state;
    private int capacity;

    public Arena(int arena_ID, String arena_name, String city,String team,String state, int capacity)
    {
        this.arena_ID = arena_ID;
        this.arena_name = arena_name;
        this.city = city;
        this.state=state;
        this.capacity = capacity;
    }

    public int getArena_ID()
    {
        return arena_ID;
    }
    public void setArena_ID(int arena_ID)
    {
        this.arena_ID = arena_ID;
    }

    public String getArena_name()
    {
        return arena_name;
    }
    public void setArena_name(String arena_name)
    {
        this.arena_name = arena_name;
    }

    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }


    public String getState()
    {
        return state;
    }
    public void setState(String state)
    {
        this.arena_name = state;
    }


    public int getCapacity()
    {
        return capacity;
    }
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public String toString()
    {
        return "Arena{" + "Arena ID=" + arena_ID + ", Arena Name=" + arena_name + ", City=" +city+", State=" + state +
                  ", Capacity=" + capacity +'}';
    }

}
