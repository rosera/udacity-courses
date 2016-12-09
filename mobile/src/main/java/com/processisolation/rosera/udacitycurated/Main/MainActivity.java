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

import static android.R.drawable.btn_star_big_off;
import static android.R.drawable.btn_star_big_on;
import static android.R.drawable.star_big_off;
import static android.R.drawable.star_big_on;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences   sharedPref;
    SharedPreferences.Editor    editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // TODO: SharedPreferences
//                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();

                sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                editor = sharedPref.edit();

                // TODO: What track?
                TextView trackTitle = (TextView) findViewById(R.id.Title);
                String tempString = trackTitle.getText().toString();

                // TODO: Reset the data
//                editor.clear();

                Boolean favouriteSetting = false;

                // TODO: Saving/Unsaving?
                switch (tempString) {
                    case "Data Science":
                        favouriteSetting = sharedPref.getBoolean("Data_Science", favouriteSetting);
                        editor.putBoolean("Data_Science", ((favouriteSetting == true) ? false:true));
                        break;
                    case "Web Development":
                        favouriteSetting = sharedPref.getBoolean("Web_Development", favouriteSetting);
                        editor.putBoolean("Web_Development", ((favouriteSetting == true) ? false:true));
                        break;
                    case "Software Engineering":
                        favouriteSetting = sharedPref.getBoolean("Software_Engineering", favouriteSetting);

                        favouriteSetting = favouriteSetting == true ? false : true;
                        editor.putBoolean("Software_Engineering", favouriteSetting);
//                        editor.putBoolean("Software_Engineering", ((favouriteSetting == true) ? false:true));
                        break;
                    case "Android":
                        favouriteSetting = sharedPref.getBoolean("Android", favouriteSetting);
                        editor.putBoolean("Android", ((favouriteSetting == true) ? false:true));
                        break;
                    case "iOS":
                        favouriteSetting = sharedPref.getBoolean("iOS", favouriteSetting);
                        editor.putBoolean("iOS", ((favouriteSetting == true) ? false:true));
                        break;
                    case "Georgia Tech Masters in CS":
                        favouriteSetting = sharedPref.getBoolean("Georgia", favouriteSetting);
                        editor.putBoolean("Georgia", ((favouriteSetting == true) ? false:true));
                        break;
                    case "Non-Tech":
                        favouriteSetting = sharedPref.getBoolean("Non_Tech", favouriteSetting);
                        editor.putBoolean("Non_Tech", ((favouriteSetting == true) ? false:true));
                        break;
                    default:
                        break;
                }

                // TODO: Save the changes
                editor.commit();

                // TODO: Toggle the button
                if (favouriteSetting)
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.favourite_circular_button_on));
                else
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.favourite_circular_button_off));

                // TODO: Show snackbar message on save/unsave
                Snackbar snackbar = Snackbar
                        .make(view, tempString + " set to: " + favouriteSetting.toString(), Snackbar.LENGTH_LONG);
                        snackbar.show();
                        //.setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
