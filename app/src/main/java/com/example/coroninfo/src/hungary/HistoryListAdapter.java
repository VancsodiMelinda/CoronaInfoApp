package com.example.coroninfo.src.hungary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.coroninfo.R;

import java.lang.reflect.Array;
import java.util.List;

public class HistoryListAdapter extends ArrayAdapter<DataContainer> {
    private static final String TAG = "HistoryListAdapter";
    private Context mContext;
    private int mResource;

    public HistoryListAdapter(@NonNull Context context, int resource, @NonNull DataContainer[] objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String date = getItem(position).currentDate;
        String confirmed = getItem(position).dailyConfirmed;
        String death = getItem(position).dailyDeath;

        DataContainer cont = new DataContainer("123", death, date);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView confirmedTv = (TextView) convertView.findViewById(R.id.HungaryDailyConfirmedTv);
        confirmedTv.setText(confirmed);

        TextView deathTv = (TextView) convertView.findViewById(R.id.HungaryDailyDeathsTv);
        deathTv.setText(death);

        TextView dateTv = (TextView) convertView.findViewById(R.id.HungaryDailyDateTv);
        dateTv.setText(date);

        return convertView;
    }
}
