package com.example.developserg.team_stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList usersArrayList;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createUsers();
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new UsersAdapter(usersArrayList, this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            boolean start = false;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chronometer chr = (Chronometer) view.findViewById(R.id.userChronometer);
                ImageView ivStatus = (ImageView) view.findViewById(R.id.statusImage);
                if (!start) {
                    chr.start();
                    ivStatus.setImageResource(R.drawable.stop);
                    Toast.makeText(getApplicationContext(),
                            "таймер для " + (position + 1) + "запустился", Toast.LENGTH_SHORT).show();
                    start = true;
                } else {
                    chr.stop();
                    ivStatus.setImageResource(R.drawable.start);
                    Toast.makeText(getApplicationContext(),
                            "таймер для " + (position + 1) + "остановился", Toast.LENGTH_SHORT).show();
                    start = false;
                }
            }
        });
    }

    private void createUsers() {
        usersArrayList = new ArrayList<>();
        Users serega = new Users();
        serega.setName("Серега");
        usersArrayList.add(serega);

        Users vova = new Users();
        vova.setName("Вова");
        usersArrayList.add(vova);

        Users denis = new Users();
        denis.setName("Денис");
        usersArrayList.add(denis);

        Users sasha = new Users();
        sasha.setName("Саша");
        usersArrayList.add(sasha);

        Users ruslan = new Users();
        ruslan.setName("Руслан");
        usersArrayList.add(ruslan);

        Users konstantin = new Users();
        konstantin.setName("Костя");
        usersArrayList.add(konstantin);

        Users roma = new Users();
        roma.setName("Рома");
        usersArrayList.add(roma);

        Users dimaR = new Users();
        dimaR.setName("Дима Р.");
        usersArrayList.add(dimaR);

        Users dimaG = new Users();
        dimaG.setName("Дима Г.");
        usersArrayList.add(dimaG);

        Users pashaA = new Users();
        pashaA.setName("Паша А.");
        usersArrayList.add(pashaA);

        Users pashaP = new Users();
        pashaP.setName("Паша П.");
        usersArrayList.add(pashaP);

        Users nikita = new Users();
        nikita.setName("Никита");
        usersArrayList.add(nikita);
    }
}
