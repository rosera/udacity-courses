package com.processisolation.rosera.udacitycurated.Main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.processisolation.rosera.udacitycurated.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;

public class UdacityMainActivity extends AppCompatActivity {

    // TODO: Add some global variables
    private ArrayList<UdacityData>      mUdacityInformation = null;
    private RecyclerView                mRecyclerView = null;
    private UdacityAdapter              mAdapter = null;

   /*
    * Name: onCreate
    * @return void
    *  Description: Initiate the RecyclerView, check internet access and populate the screen
    *
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udacity_main);

        // Load the recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.udacity_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Allocate memory for the course information
        mUdacityInformation = new ArrayList<>();

        // Call Volley
        if (getOnlineStatus()) {
            // Online - make the network request
            onRequestUdacityAPI();
        }
        else {
            // Offline - display an appropriate message
            Toast.makeText(getApplicationContext(), "Please check your internet connectivity", Toast.LENGTH_LONG).show();
        }

        // Add a listener for the RecyclerView - Ref: Mastering Android Application Development p100
        mRecyclerView.addOnItemTouchListener(new UdacityItemClickListener(getApplicationContext(), mRecyclerView, new UdacityItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "Selected: " + mUdacityInformation.get(position).getCourseTitle(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    /*
     * Name: getOnlineStatus
     * @return boolean - flag to indicate network status
     *  False:  Offline
     *  True:   Online
     * Description: Check on the device network status
     * Comment: Standard method on which to check the network availability
     *          Ensure required permissions have been added to Android.Manifest
     */

    public boolean getOnlineStatus() {
        ConnectivityManager connMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }


    /*
     * Name: onRequestUdacityAPI
     * Comment: Access the Udacity API using the Volley library
     *
     */

    private void onRequestUdacityAPI() {

        // TODO: Build HTTP Request to the Udacity API
        final String UDACITY_API_URI = "https://www.udacity.com/public-api/v0/courses";


        final JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest
//                (Method.GET, MOVIE_API_URI, null, new Response.Listener<JSONObject>() {
                (Request.Method.GET,UDACITY_API_URI, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            // TODO: Get the response array

                            // Read and process degrees object
                            JSONArray jsonArray = response.getJSONArray("degrees");

                            // Read and process tracks object
//                            JSONArray jsonArray = response.getJSONArray("tracks");

                            // Read and process courses object
//                            JSONArray jsonArray = response.getJSONArray("courses");

                            // TODO: Allocate local variables to hold the information
                            String  key              = "";
                            String  title            = "";
                            String  subtitle         = "";
                            String  description      = "";
                            String  image            = "";
                            String  req_knowledge;
                            String  syllabus;
                            String  homepage;
                            String  level;
                            String  duration_unit;
                            int     duration;


                            // TODO: Loop through the array
                            for (int i=0; i < jsonArray.length(); i++) {

                                // TODO: Get the object details - examine the available properties

                                // TODO: Get the data object
                                JSONObject content = jsonArray.getJSONObject(i);
                                key = content.getString("key");
                                title = content.getString("title");
                                subtitle = content.getString("subtitle");
                                description = content.getString("short_summary");
                                image = content.getString("banner_image");
//                                req_knowledge = content.getString("required_knowledge");
//                                syllabus = content.getString("syllabus");
//                                homepage = content.getString("homepage");
                                level = content.getString("level");
                                duration_unit = content.getString("expected_duration_unit");
                                duration = content.getInt("expected_duration");


                                // TODO: Add to Udacity structure
                                mUdacityInformation.add(new UdacityData(subtitle, key, image,
                                        title, level, duration_unit, duration, "", FALSE, description));
                            }

                            // TODO: Set the adapter for the response data
                            mRecyclerView.setAdapter(new UdacityAdapter(mUdacityInformation, R.layout.list_item_udacity, getApplicationContext()));
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Log.i("JSON", error.getMessage());
                    }
                });

        // Initiate a volley request queue
        Volley.newRequestQueue(getApplicationContext()).add(mJsonObjectRequest);
    }

}
