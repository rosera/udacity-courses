package com.processisolation.rosera.udacitycurated.Main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.processisolation.rosera.udacitycurated.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add/Remove action for favourites", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // TODO: SharedPreferences
                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                // TODO: What track?
                TextView trackTitle = (TextView) findViewById(R.id.Title);
                String tempString = trackTitle.getText().toString();

                Boolean favouriteSetting = false;

                // TODO: Saving/Unsaving?
                switch (tempString) {
                    case "Data Science":
                        favouriteSetting = sharedPref.getBoolean("Data_Science", favouriteSetting);
                        editor.putBoolean("Data_Science", (favouriteSetting == true) ? false:true);
                        break;
                    case "Web Development":
                        favouriteSetting = sharedPref.getBoolean("Web Development", favouriteSetting);
                        editor.putBoolean("Web_Development", (favouriteSetting == true) ? false:true);
                        break;
                    case "Software Engineering":
                        favouriteSetting = sharedPref.getBoolean("Software Engineering", favouriteSetting);
                        editor.putBoolean("Software_Engineering", (favouriteSetting == true) ? false:true);
                        break;
                    case "Android":
                        favouriteSetting = sharedPref.getBoolean("Android", favouriteSetting);
                        editor.putBoolean("Android", (favouriteSetting == true) ? false:true);
                        break;
                    case "iOS":
                        favouriteSetting = sharedPref.getBoolean("iOS", favouriteSetting);
                        editor.putBoolean("iOS", (favouriteSetting == true) ? false:true);
                        break;
                    case "Georgia Tech Masters in CS":
                        favouriteSetting = sharedPref.getBoolean("Georgia Tech Masters in CS", favouriteSetting);
                        editor.putBoolean("Georgia", (favouriteSetting == true) ? false:true);
                        break;
                    case "Non-Tech":
                        favouriteSetting = sharedPref.getBoolean("Non-Tech", favouriteSetting);
                        editor.putBoolean("Non_Tech", (favouriteSetting == true) ? false:true);
                        break;
                    default:
                        break;
                }

                // TODO: Save the changes
                editor.commit();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
