package com.example.developserg.team_stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<User> usersArrayList = createUsers();
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new UserAdapter(usersArrayList, this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chronometer chr = (Chronometer) view.findViewById(R.id.userChronometer);
                ImageView ivStatus = (ImageView) view.findViewById(R.id.statusImage);
//                User user = usersArrayList.get(position);

                for (User temp : usersArrayList) {
                    Chronometer chrr = (Chronometer) view.findViewWithTag("chrono");
                    temp.stopChrono();
                    chrr.stop();
                }
                chr.start();

//                for (int i = 0; i < usersArrayList.size(); i++) {
//                    Chronometer chrr = (Chronometer) view.findViewWithTag("chrono" + position);
//                    chrr.stop();
//                }
//                if (user.isStart()) {
//                    chr.stop();
//                    ivStatus.setImageResource(R.drawable.start);
//                    Toast.makeText(getApplicationContext(),
//                            "таймер для " + (position + 1) + "остановился", Toast.LENGTH_SHORT).show();
//                    user.setFalse();
//                    for (int i = 0; i < usersArrayList.size(); i++) {
//                        Chronometer chrr = (Chronometer) view.findViewWithTag("chrono" + position);
//                        chrr.stop();
//                    }
////                    for (User userr : usersArrayList) {
////
//////                        userr.stopChrono();
////                    }
//                } else {
//                    chr.start();
//                    ivStatus.setImageResource(R.drawable.stop);
//                    Toast.makeText(getApplicationContext(),
//                            "таймер для " + (position + 1) + "запустился", Toast.LENGTH_SHORT).show();
////                    for (int i = 0; i < usersArrayList.size(); i++) { //сбрасываем флаги
////                        Users p = (Users) usersArrayList.get(position);
////                        p.setFalse();
////                    }
//                    user.setTrue();
//                }
            }
        });
    }


    private List createUsers() {
        List<User> usersArrayList = new ArrayList<>();
        User serega = new User();
        serega.setName("Серега");
        usersArrayList.add(serega);

        User vova = new User();
        vova.setName("Вова");
        usersArrayList.add(vova);

        User denis = new User();
        denis.setName("Денис");
        usersArrayList.add(denis);

        User sasha = new User();
        sasha.setName("Саша");
        usersArrayList.add(sasha);

        User ruslan = new User();
        ruslan.setName("Руслан");
        usersArrayList.add(ruslan);

//        Users konstantin = new Users();
//        konstantin.setName("Костя");
//        usersArrayList.add(konstantin);
//
//        Users roma = new Users();
//        roma.setName("Рома");
//        usersArrayList.add(roma);
//
//        Users dimaR = new Users();
//        dimaR.setName("Дима Р.");
//        usersArrayList.add(dimaR);
//
//        Users dimaG = new Users();
//        dimaG.setName("Дима Г.");
//        usersArrayList.add(dimaG);
//
//        Users pashaA = new Users();
//        pashaA.setName("Паша А.");
//        usersArrayList.add(pashaA);
//
//        Users pashaP = new Users();
//        pashaP.setName("Паша П.");
//        usersArrayList.add(pashaP);
//
//        Users nikita = new Users();
//        nikita.setName("Никита");
//        usersArrayList.add(nikita);
        return usersArrayList;
    }
}

