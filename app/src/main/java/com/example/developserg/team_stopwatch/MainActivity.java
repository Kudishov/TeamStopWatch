package com.example.developserg.team_stopwatch;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<User> usersArrayList;
    public List<Chronometer> chronometerList = new ArrayList<>();
    public ListView listView;
    UserAdapter UA;
    Button addButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createUsers();
        addButton = (Button) findViewById(R.id.button_add);
        resetButton = (Button) findViewById(R.id.button_reset);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAdd(v);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < listView.getCount(); i++) {
                    v = listView.getChildAt(i);
                    User user = usersArrayList.get(i);
                    ImageView ivStatus = (ImageView) v.findViewById(R.id.statusImage);
                    Chronometer chrr = (Chronometer) v.findViewById(R.id.userChronometer);
                    chrr.stop();
                    chrr.setBase(SystemClock.elapsedRealtime());
                    user.setTimeWhenStopped(0);
                    user.setFalse();
                    ivStatus.setImageResource(R.drawable.start);
                }
                UA.notifyDataSetChanged();
            }
        });

        listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        UA = new UserAdapter(usersArrayList, this);
        listView.setAdapter(UA);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chronometer chr = (Chronometer) view.findViewById(R.id.userChronometer);
                View v;
                ImageView ivStatus = (ImageView) view.findViewById(R.id.statusImage);
                User user = usersArrayList.get(position);
                if (user.isStart()) {
                    user.setTimeWhenStopped(chr.getBase() - SystemClock.elapsedRealtime());
                    chr.stop();
                    ivStatus.setImageResource(R.drawable.start);
                    user.setFalse();
                } else {
                    for (int i = 0; i < listView.getCount(); i++) {
                        v = listView.getChildAt(i);
                        User user2 = usersArrayList.get(i);
                        if (user2.isStart()) {
                            Chronometer chrr = (Chronometer) v.findViewById(R.id.userChronometer);
                            ImageView ivvStatus = (ImageView) v.findViewById(R.id.statusImage);
                            user2.setTimeWhenStopped(chrr.getBase() - SystemClock.elapsedRealtime());
                            chrr.stop();
                            ivvStatus.setImageResource(R.drawable.start);
                            user2.setFalse();
                        }
                    }
                    ivStatus.setImageResource(R.drawable.stop);
                    chr.setBase(SystemClock.elapsedRealtime() + user.getTimeWhenStopped());
                    chr.start();
                    user.setTrue();
                }
            }
        });
    }

    private List createUsers() {
        usersArrayList = new ArrayList<>();

        Chronometer chr1 = new Chronometer(this);
        chronometerList.add(chr1);
        Chronometer chr2 = new Chronometer(this);
        chronometerList.add(chr2);
        Chronometer chr3 = new Chronometer(this);
        chronometerList.add(chr3);
        Chronometer chr4 = new Chronometer(this);
        chronometerList.add(chr4);
        Chronometer chr5 = new Chronometer(this);
        chronometerList.add(chr5);

        User serega = new User("Серега", chr1);
        usersArrayList.add(serega);
        User boris = new User("Борис", chr2);
        usersArrayList.add(boris);
        User ded = new User("Дед МОРОЗ", chr3);
        usersArrayList.add(ded);
        User superman = new User("SUPERMAN", chr4);
        usersArrayList.add(superman);
        User spider = new User("Spider Man", chr5);
        usersArrayList.add(spider);
        return usersArrayList;
    }


    public void onClickAdd(View view) {
        final View customView = getLayoutInflater().inflate(R.layout.add_layout, null);
        new AlertDialog.Builder(this)
                .setView(customView)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etLogin = ((EditText) customView.findViewById(R.id.editText_Name));
                        assert etLogin != null;
                        String login = etLogin.getText().toString();
                        Chronometer chronometer = new Chronometer(MainActivity.this);
                        chronometerList.add(chronometer);
                        User user = new User(login, chronometer);
                        usersArrayList.add(user); // TODO: 15.06.2016 Добавление элемента в новую ячейку массива
                        UA.notifyDataSetChanged();
                    }
                })
                .create()
                .show();
    }
}
