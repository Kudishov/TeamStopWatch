package com.example.developserg.team_stopwatch;

import android.os.SystemClock;
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

    public List<User> usersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createUsers();
        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setAdapter(new UserAdapter(usersArrayList, this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chronometer chr = (Chronometer) view.findViewById(R.id.userChronometer);
                ImageView ivStatus = (ImageView) view.findViewById(R.id.statusImage);
                User user = usersArrayList.get(position);

                if (user.isStart()) {
                    chr.stop();
                    ivStatus.setImageResource(R.drawable.start);
                    user.setFalse();
                } else {
                    ivStatus.setImageResource(R.drawable.stop);
                    chr.setBase(SystemClock.elapsedRealtime());
                    chr.start();
                    user.setTrue();
                }
            }
        });
    }


    private List createUsers() {
        usersArrayList = new ArrayList<>();
        Chronometer chr1 = new Chronometer(this);
        Chronometer chr2 = new Chronometer(this);
        Chronometer chr3 = new Chronometer(this);
        Chronometer chr4 = new Chronometer(this);
        Chronometer chr5 = new Chronometer(this);

        User serega = new User("Серега", chr1);
        serega.setChronoUser(chr1);
        usersArrayList.add(serega);

        User boris = new User("Борис", chr2);
        boris.setChronoUser(chr2);
        usersArrayList.add(boris);

        User ded = new User("Дед МОРОЗ", chr3);
        ded.setChronoUser(chr3);
        usersArrayList.add(ded);

        User superman = new User("SUPERMAN", chr3);
        superman.setChronoUser(chr4);
        usersArrayList.add(superman);

        User spider = new User("Spider Man", chr3);
        spider.setChronoUser(chr5);
        usersArrayList.add(spider);

        return usersArrayList;
    }
}
