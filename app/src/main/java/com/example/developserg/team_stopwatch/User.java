package com.example.developserg.team_stopwatch;

import android.view.View;
import android.widget.Chronometer;

import java.util.ArrayList;

/**
 * Created by DevelopSerg on 13.04.2016.
 */
public class User {
    private String name;
    private boolean start;
    private Chronometer chronoUser;

    public Chronometer getChronoUser() {
        return chronoUser;
    }

    public void stopChrono (){
        chronoUser.stop();
    }

    public void setChronoUser(Chronometer chronoUser) {
        this.chronoUser = chronoUser;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isStart() {
        return start;
    }

    public void setIsStarted(boolean isStarted) {
        this.start = isStarted;
    }

    public void setTrue() {
        this.start = true;
    }

    public void setFalse() {
        this.start = false;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
