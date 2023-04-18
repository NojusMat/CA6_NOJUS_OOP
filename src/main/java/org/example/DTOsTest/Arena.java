package org.example.DTOsTest;

public class Arena implements Comparable<Arena>{
    private int arena_ID;
    private String arena_name;
    private int capacity;

    public Arena(int arena_ID, String arena_name, int capacity)
    {
        this.arena_ID = arena_ID;
        this.arena_name = arena_name;
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

        System.out.println("------------------------------------------------------------------------------------------------");
        return "Arena{" + "Arena ID=" + arena_ID + ", Arena Name=" + arena_name +
                  ", Capacity=" + capacity +'}';
    }

    @Override
    public int compareTo(Arena otherArena)
    {
        if( this.capacity > otherArena.capacity )        // will result in ascending order
            return -1;
        else if( this.capacity == otherArena.capacity)
            return 0;
        else
            return 1;
    }
}
