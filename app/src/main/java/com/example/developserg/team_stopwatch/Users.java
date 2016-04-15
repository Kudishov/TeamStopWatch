package com.example.developserg.team_stopwatch;

/**
 * Created by DevelopSerg on 13.04.2016.
 */
public class Users {
    private String name;
    public boolean start;

    public boolean isStart() {
        return start;
    }

    public void setIsStarted(boolean isStarted) {
        this.start = isStarted;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
