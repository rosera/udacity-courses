package com.processisolation.rosera.udacitycurated.Main;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UdacityMainActivity extends AppCompatActivity {

    // TODO: Debug TAG
    private static final String TAG_NAME = UdacityMainActivity.class.getSimpleName();


    // TODO: Add some global variables
//    private ArrayList<UdacityData>      mUdacityDegreesInformation  = null;
    private ArrayList<TracksData>       mTracksInformation = null;
    private ArrayList<CoursesData>      mCoursesInformation  = null;
    private Map mMapCourses              = new HashMap<>();

//    private Test mTestMap           = new Test();

    private RecyclerView                mRecyclerView               = null;
//    private UdacityAdapter              mAdapter                    = null;
    private JSONArray                   mJsonArrayResponseCourses   = null;
    private JSONArray                   mJsonArrayResponseTracks    = null;

    // TODO: Rethink local database/maybe better
//    private RealmConfiguration          mRealmConfiguration          = null;
//    private Realm                       mRealm                      = null;

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


        // TODO: Check the device density to correct the number of grid items
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
//                getScreenDensity(), StaggeredGridLayoutManager.VERTICAL);
//
//        layoutManager.setGapStrategy(
//                StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, getScreenDensity()));

        // Allocate memory for the course information
        mTracksInformation = new ArrayList<>();
        mCoursesInformation = new ArrayList<>();

        // TODO: Mechanism to perform quick course id lookup via HashMap
//        createCourseHashMap();

//        mUdacityDegreesInformation = new ArrayList<>();
//        mUdacityCoursesInformation = new ArrayList<>();

        // TODO: Set the adapter for the response data
//        mRecyclerView.setAdapter(new UdacityAdapter(mUdacityDegreesInformation,
//                R.layout.list_item_udacity, getApplicationContext()));

        // TODO: Reference data held in the Udacity API
        if (getOnlineStatus()) {
            // Online - make the network request
            onRequestUdacityAPI();
        }
        else {

            offlineUdacityAPI();

            // Offline - display an appropriate message
            Toast.makeText(getApplicationContext(), "Please check your internet connectivity",
                    Toast.LENGTH_LONG).show();
        }

        // Add a listener for the RecyclerView - Ref: Mastering Android Application Development p100
        mRecyclerView.addOnItemTouchListener(new UdacityItemClickListener(getApplicationContext(),
                mRecyclerView, new UdacityItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                CoursesData tempData = mCoursesInformation.get(position);

                ArrayList<CoursesData> tempArrayData = mTracksInformation.get(position).getCourseList();

                CoursesData tempData2 = tempArrayData.get(position);


                // Initiate a new activity for the onscreen item clicked
                Intent intent = new Intent(getApplicationContext(), MainActivity.class)
                    .putExtra("Courses", mTracksInformation.get(position).getCourses())
                    .putExtra("Images", mTracksInformation.get(position).getCourseImages())
//                        .putExtra("CourseList", mTestMap)
//                    .putExtra("CourseList", mCoursesInformation)
//                        .putParcelableArrayListExtra("CourseList", mTracksInformation.get(position).getCourseList())
                        .putParcelableArrayListExtra ("CourseList", mTracksInformation.get(position).getCourseList())
                    .putExtra("Name", mTracksInformation.get(position).getName())
                    .putExtra("Title", mTracksInformation.get(position).getCourseName())
                    .putExtra("Description", mTracksInformation.get(position).getDescription());

                // Commence the new intent for track course overview
                startActivity(intent);
            }
        }));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mRealm.close();
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
        ConnectivityManager connMgr = (ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }



    public void offlineUdacityAPI() {

        try {
            // Offline access
            JSONObject responseOffline = new JSONObject(getOfflineContent());

            // TODO: initiate the member response variable
            mJsonArrayResponseCourses   = responseOffline.getJSONArray("courses");
            mJsonArrayResponseTracks    = responseOffline.getJSONArray("tracks");

//                            JSONArray jsonArrayDegree = response.getJSONArray("degrees");

            // TODO: Loop through the Course array
            for (int i = 0; i < mJsonArrayResponseCourses.length(); i++) {

                // TODO: Set the parsed degree information
                setCourseInformation(mJsonArrayResponseCourses, i);
            }

            // TODO: Loop through the Tracks array
            for (int i = 0; i < mJsonArrayResponseTracks.length(); i++) {

                // TODO: Set the parsed degree information
                setTrackInformation(mJsonArrayResponseTracks, i);
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        // TODO: Set the adapter for the response data
        mRecyclerView.setAdapter(new UdacityAdapter(mTracksInformation, R.layout.list_item_udacity, getApplicationContext()));
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
                (Request.Method.GET,UDACITY_API_URI, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(final JSONObject response) {

                        // TODO: Localise the MAP structure - not required as a global

                        try {
                            // Offline access
//                            JSONObject responseOffline = new JSONObject(getOfflineContent());


                            // TODO: initiate the member response variable
                            mJsonArrayResponseCourses   = response.getJSONArray("courses");
                            mJsonArrayResponseTracks    = response.getJSONArray("tracks");

//                            JSONArray jsonArrayDegree = response.getJSONArray("degrees");

                            // TODO: Loop through the Course array
                            for (int i = 0; i < mJsonArrayResponseCourses.length(); i++) {

                                 // TODO: Set the parsed degree information
                                setCourseInformation(mJsonArrayResponseCourses, i);
                            }

                            // TODO: Loop through the Tracks array
                            for (int i = 0; i < mJsonArrayResponseTracks.length(); i++) {

                                // TODO: Set the parsed degree information
                                setTrackInformation(mJsonArrayResponseTracks, i);
                            }

                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }

                        // TODO: Set the adapter for the response data
                        mRecyclerView.setAdapter(new UdacityAdapter(mTracksInformation, R.layout.list_item_udacity, getApplicationContext()));

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        // Queue the async request
        Volley.newRequestQueue(getApplicationContext()).add(mJsonObjectRequest);
    }


    public void setDegreeInformation(JSONArray jsonDegreesArray, int position) {

        // TODO: Get the object details - examine the available properties
        String  key             = "";
        String  title           = "";
        String  subtitle        = "";
        String  description     = "";
        String  summary         = "";
        String  image           = "";
        String  syllabus        = "";
        String  homepage        = "";
        String  level           = "";
        String  duration_unit   = "";
        String instructors      = "";
        int     duration;

        try {
            // TODO: Get the data object
            JSONObject jsonObjectDegree = jsonDegreesArray.getJSONObject(position);
            key = jsonObjectDegree.getString("key");
            title = jsonObjectDegree.getString("title");
//            track = jsonObjectDegree.getString("track");
            subtitle = jsonObjectDegree.getString("subtitle");
            summary = jsonObjectDegree.getString("short_summary");
            description = jsonObjectDegree.getString("summary");
            image = jsonObjectDegree.getString("banner_image");
    //                                req_knowledge = jsonObjectDegree.getString("required_knowledge");
            syllabus = jsonObjectDegree.getString("syllabus");
            homepage = jsonObjectDegree.getString("homepage");
            level = jsonObjectDegree.getString("level");
            duration_unit = jsonObjectDegree.getString("expected_duration_unit");
            duration = jsonObjectDegree.getInt("expected_duration");

            // TODO: Add to Udacity structure
//            mUdacityDegreesInformation.add(new UdacityData(subtitle, key, image,
//                    title, level, duration_unit, duration, homepage, 0, summary,description,
//                    syllabus, instructors));

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }


    public void setTrackInformation(JSONArray jsonDegreesArray, int position) {

        // TODO: Get the object details - examine the available properties
        String  name            = "";
        String  description     = "";
        String[] courseIds;
        String[] courseImages;
        String[] courseName;

        CoursesData tempCourseData;

        try {
            // TODO: Get the data object
            JSONObject jsonObjectTrack = jsonDegreesArray.getJSONObject(position);

            // TODO: Access the json object names
            name = jsonObjectTrack.getString("name");
            description = jsonObjectTrack.getString("description") ;

            // TODO: Access the course information stored as an Array
            JSONArray jsonArray = jsonObjectTrack.getJSONArray("courses");

            // TODO: Set the length of the course list to Array length
            courseIds = new String[jsonArray.length()];
            courseImages = new String[jsonArray.length()];
            courseName = new String[jsonArray.length()];
            ArrayList<CoursesData> coursedata;

            coursedata = new ArrayList<>();


            // TODO: Get the course id
            for (int i=0; i < jsonArray.length(); i++) {
                courseIds[i] = jsonArray.get(i).toString() ;

                // TODO: For each course id, get the associate image
                if (mMapCourses.containsKey(courseIds[i])) {
//                if (mTestMap.mMapCourses.containsKey(courseIds[i])) {

                    // TODO: Dereference the course data to access object methods
                    tempCourseData = (CoursesData) mMapCourses.get(courseIds[i]);
//                    tempCourseData = (CoursesData)mTestMap.mMapCourses.get(courseIds[i]);
                    courseImages[i] = tempCourseData.getCourseImage();
                    courseName[i] = tempCourseData.getCourseTitle();

                    // Add each course data reference
                    coursedata.add(tempCourseData);
                }
            }

            // TODO: Add to Udacity structure

            // Add track/course information:
            mTracksInformation.add(new TracksData(name,description, courseIds, courseImages, courseName, coursedata));

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    public void setCourseInformation(JSONArray jsonCoursesArray, int position) {

        // TODO: Get the object details - examine the available properties
        String  key             = "";
        String  title           = "";
        String  subtitle        = "";
        String  description     = "";
        String  summary         = "";
        String  image           = "";
        String  syllabus        = "";
        String  homepage        = "";
        String  level           = "";
        String  duration_unit   = "";
        String  expected_learning = "";
        String required_knowledge = "";

        JSONArray instructors ;
        JSONObject instructor ;
        String[] instructor_name;
        String[] instructor_image;
        String[] instructor_bio;


        int     duration;

        try {
            // TODO: Get the data object
            JSONObject jsonObjectCourse = jsonCoursesArray.getJSONObject(position);

            key = jsonObjectCourse.getString("key");
            title = jsonObjectCourse.getString("title");
//            track = jsonObjectCourse.getString("track");
            subtitle = jsonObjectCourse.getString("subtitle");
            summary = jsonObjectCourse.getString("short_summary");
            description = jsonObjectCourse.getString("summary");
            required_knowledge = jsonObjectCourse.getString("required_knowledge");
            expected_learning = jsonObjectCourse.getString("expected_learning");
            image = jsonObjectCourse.getString("image");
//                                req_knowledge = jsonObjectCourse.getString("required_knowledge");

            syllabus = jsonObjectCourse.getString("syllabus");
            homepage = jsonObjectCourse.getString("homepage");
            level = jsonObjectCourse.getString("level");
            duration_unit = jsonObjectCourse.getString("expected_duration_unit");
            duration = jsonObjectCourse.getInt("expected_duration");
             instructors = jsonObjectCourse.getJSONArray("instructors");

            if (instructors.length()>0) {
                // Allocate the appropriate amount of memory
                instructor_name = new String[instructors.length()];
                instructor_image = new String[instructors.length()];
                instructor_bio = new String[instructors.length()];

                // TODO: Loop through the instructor list
                for (int i=0; i < instructors.length(); i++) {
                    instructor = instructors.getJSONObject(i);
                    instructor_name[i] = instructor.getString("name");
                    instructor_image[i] = instructor.getString("image");
                    instructor_bio[i] = instructor.getString("bio");
                }
            } else {
                // TODO: Allocate memory
                instructor_name = new String[1];
                instructor_image = new String[1];
                instructor_bio = new String[1];
                // TODO Add details where none provided

                instructor_name[0] = "Not specified";
                instructor_image [0] = "Not specified";
                instructor_bio[0] = "Not specified";
            }

            // TODO: Update the HashMap with a new reference
            if (!mMapCourses.containsKey(key)) {
//            if (!mTestMap.mMapCourses.containsKey(key) && key.length()>0) {
                mMapCourses.put(key, new CoursesData(subtitle, key, image,
//                mTestMap.mMapCourses.put(key, new CoursesData(subtitle, key, image,
                        title, level, duration_unit, duration, homepage, 0, summary,
                        description, syllabus, expected_learning, instructor_name, instructor_image,
                        instructor_bio, required_knowledge));

//                CoursesData tempObject = (CoursesData) mMapCourses.get(key);
                // Store parcelable object

                mCoursesInformation.add((CoursesData) mMapCourses.get(key));
//                mCoursesInformation.add((CoursesData) mTestMap.mMapCourses.get(key));
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }


    public void createCourseHashMap() {

        // TODO: Generated from python script - see udacity2.py
    }


    public String getOfflineContent() {

        String json = null;

        try {
            InputStream is = getApplicationContext().getAssets().open("udacity.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }


    public int getScreenDensity() {
        final DisplayMetrics metrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int density = metrics.densityDpi;
        int widthPixels = metrics.widthPixels;

        int  intLayoutControls = 4;

        if (widthPixels < 721)
            intLayoutControls = 1;
        else if (widthPixels < 1025)
            intLayoutControls = 3;
        else
            intLayoutControls = 4;

        return intLayoutControls;
    }


}

