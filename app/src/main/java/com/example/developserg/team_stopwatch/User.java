package com.example.developserg.team_stopwatch;

import android.view.View;
import android.widget.Chronometer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DevelopSerg on 13.04.2016.
 */
public class User {
    private String name;
    private boolean start;
    private Chronometer chronoUser;

    public User(String name, Chronometer chronoUser) {
        this.name = name;
        this.chronoUser = chronoUser;
    }

    public Chronometer getChronoUser() {
        return this.chronoUser;
    }

    public void stopChrono (){
        this.chronoUser.stop();
    }

    public void setChronoUser(Chronometer chronoUser) {
        this.chronoUser = chronoUser;
    }

    public boolean isStart() {
        return this.start;
    }

    public void setTrue() {
        this.start = true;
    }

    public void setFalse() {
        this.start = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
