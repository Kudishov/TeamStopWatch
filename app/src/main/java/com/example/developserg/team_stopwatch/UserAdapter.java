package com.example.developserg.team_stopwatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    private List<User> userAdapterArrayList;
    private Context context;

    public UserAdapter(List<User> userAdapterArrayList, Context context) {
        this.userAdapterArrayList = userAdapterArrayList;
        this.context = context;
    }

    @Override
    public int getCount() { //сколько данных вообще есть?
        return userAdapterArrayList.size();
    }

    @Override
    public Object getItem(int position) { //дай мне элемент данных под номером position
        return userAdapterArrayList.get(position);
    }

    @Override
    public long getItemId(int position) { //дай мне id position
        return position;
    }

    @Override
    //сверстать View, наполнить данными и вернуть
    public View getView(int position, View convertView, ViewGroup parent) {
        User p = userAdapterArrayList.get(position);

        View usersView = convertView;
        if (usersView == null) {
            usersView = LayoutInflater.from(context).inflate(R.layout.user_layout, null);
        }

        TextView tvNname = (TextView) usersView.findViewById(R.id.name);
        tvNname.setText(p.getName());

        Chronometer viewChrono = (Chronometer) usersView.findViewById(R.id.userChronometer);
        p.setChronoUser(viewChrono);
        viewChrono.setTag("chrono");

        return usersView;
    }
}
