package com.shijin.oddoreven;


public class Team {
    private int position;
    private String name;
    private int wins;

    public Team(int position, String name, int wins)
    {
        this.setPosition(position);
        this.setName(name);
        this.setWins(wins);
        
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

   
}
