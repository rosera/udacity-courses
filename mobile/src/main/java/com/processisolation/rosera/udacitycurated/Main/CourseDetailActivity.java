package com.processisolation.rosera.udacitycurated.Main;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.processisolation.rosera.udacitycurated.R;
import com.squareup.picasso.Picasso;

public class CourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        ImageView headerImage = (ImageView) findViewById(R.id.header_image);
//        String headerURI = getIntent().getExtras().getString("Image");
//
//
////         TODO: Ensure there is an image to load
//        if (headerURI.length() > 0) {
//            Picasso.with(getApplicationContext())
//                    .load(headerURI)
//                    .into(toolbar.setBackground());
//        } else {
//            headerImage.setImageDrawable(getResources().getDrawable(R.drawable.android));
//        }

//        toolbar.setBackground(getResources().getDrawable(R.drawable.nd006, getTheme()));




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
