package com.example.android.quakereport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public final class QueryUtils {

    /** Sample JSON response for a USGS query */
    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of {@link Earthquake} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<Earthquake> extractEarthquakes(String SAMPLE_JSON_RESPONSE) {

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        if(SAMPLE_JSON_RESPONSE.isEmpty() || SAMPLE_JSON_RESPONSE==null){
            return null;
        }


        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of Earthquake objects with the corresponding data.
            JSONObject root = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray arr = root.getJSONArray("features");
            for(int i=0;i<arr.length();i++){
                JSONObject props = arr.getJSONObject(i).getJSONObject("properties");
                earthquakes.add(new Earthquake(props.getDouble("mag"),props.getString("place"),getDate(props.getLong("time")),props.getString("url")));
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }

    public static String getDate(long l){
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-DD-yyyy  h:mm a");
        return dateFormat.format(date);
    }





}
