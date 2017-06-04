package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.android.quakereport.R.id.mag;

/**
 * Created by dewan on 5/30/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> list){
        super(context,0,list);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Earthquake earthquake = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);
        }
        // Lookup view for data population
        TextView eqMag = (TextView) convertView.findViewById(mag);
        TextView eqOffset = (TextView) convertView.findViewById(R.id.offset);
        TextView eqLoc = (TextView) convertView.findViewById(R.id.loc);
        TextView eqDate = (TextView) convertView.findViewById(R.id.date);
        // Populate the data into the template view using the data object
        GradientDrawable magCirc = (GradientDrawable) convertView.findViewById(R.id.mag).getBackground();
        double magVal = earthquake.getMag();
        int color =0;

        if(magVal<2){
            color = ContextCompat.getColor(getContext(),R.color.mag1);
            magCirc.setColor(color);
        }else if(magVal>=2 && magVal<3){
            color = ContextCompat.getColor(getContext(),R.color.mag2);
            magCirc.setColor(color);
        }else if(magVal>=3 && magVal<4){
            color = ContextCompat.getColor(getContext(),R.color.mag3);
            magCirc.setColor(color);
        }else if(magVal>=4 && magVal<5){
            color = ContextCompat.getColor(getContext(),R.color.mag4);
            magCirc.setColor(color);
        }else if(magVal>=5 && magVal<6){
            color = ContextCompat.getColor(getContext(),R.color.mag5);
            magCirc.setColor(color);
        }else if(magVal>=6 && magVal<7){
            color = ContextCompat.getColor(getContext(),R.color.mag6);
            magCirc.setColor(color);
        }else if(magVal>=7 && magVal<8){
            color = ContextCompat.getColor(getContext(),R.color.mag7);
            magCirc.setColor(color);
        }else if(magVal>=8 && magVal<9){
            color = ContextCompat.getColor(getContext(),R.color.mag8);
            magCirc.setColor(color);
        }else if(magVal>=9 && magVal<10){
            color = ContextCompat.getColor(getContext(),R.color.mag9);
            magCirc.setColor(color);
        }else{
            color = ContextCompat.getColor(getContext(),R.color.mag10);
            magCirc.setColor(color);
        }
        DecimalFormat formatter = new DecimalFormat("0.0");
        eqMag.setText(formatter.format(magVal));
        String[] loc = splitLocation(earthquake.getLoc());
        eqOffset.setText(loc[0]);
        eqLoc.setText(loc[1]);
        eqDate.setText(""+earthquake.getDate());
        // Return the completed view to render on screen
        return convertView;
    }

    public String[] splitLocation(String s){
        String[] res = new String[2];
        if(s.contains(" of ")){
            int i = s.indexOf(" of ");
            res[0] = s.substring(0,i+4);
            res[1] = s.substring(i+4,s.length());
            return res;
        }
        res[0] = "Near the";
        res[1] = s;
        return res;
    }
}
