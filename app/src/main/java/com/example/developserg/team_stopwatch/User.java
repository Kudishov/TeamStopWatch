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
    private long timeWhenStopped = 0;

    public long getTimeWhenStopped() {
        return timeWhenStopped;
    }

    public void setTimeWhenStopped(long timeWhenStopped) {
        this.timeWhenStopped = timeWhenStopped;
    }

    public User(String name, Chronometer chronoUser) {
        this.name = name;
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
