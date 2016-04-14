package com.example.developserg.team_stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Users> usersArrayList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_friends);
        createFriend();
        fillList();
    }

    private void fillList() {
        listView.setAdapter(new UsersAdapter(usersArrayList, this));
    }

    private void createFriend() {
        usersArrayList = new ArrayList<>();
        Users p = new Users();
        p.setName("Serega");
        usersArrayList.add(p);

        Users boris = new Users();
        boris.setName("Boris");
        usersArrayList.add(boris);
    }
}
