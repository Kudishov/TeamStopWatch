package com.example.developserg.team_stopwatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DevelopSerg on 12.04.2016.
 */
public class UsersAdapter extends BaseAdapter {
    private ArrayList<Users> usersArrayList;
    private Context context;

    public UsersAdapter(ArrayList<Users> usersArrayList, Context context) {
        this.usersArrayList = usersArrayList;
        this.context = context;
    }

    // Дергает ListView когда появляется потребность в выводе данных на экране
    @Override
    public int getCount() { //сколько данных вообще есть?
        return usersArrayList.size();
    }

    @Override
    public Object getItem(int position) { //дай мне элемент данных под номером position
        return usersArrayList.get(position);
    }

    @Override
    public long getItemId(int position) { //дай мне id position
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //сверстать View, наполнить данными и вернуть
        Users p = usersArrayList.get(position); //получили доступ к данным

        View friendView = convertView;
        if (friendView == null) { //если мы получили новый элемент, то надо его создать
            friendView = LayoutInflater.from(context).inflate(R.layout.user_layout, null);
        }

        TextView tvNname = (TextView) friendView.findViewById(R.id.name);
        tvNname.setText(p.getName());

        return friendView;
    }
}