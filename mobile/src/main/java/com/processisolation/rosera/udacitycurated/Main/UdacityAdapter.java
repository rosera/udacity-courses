package com.processisolation.rosera.udacitycurated.Main;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.processisolation.rosera.udacitycurated.R;

import java.util.List;


/**
 * Created by rosera on 02/11/16.
 */

public class UdacityAdapter extends RecyclerView.Adapter<UdacityAdapter.UdacityViewHolder>{

    private List<TracksData>    tracks;
    private int                 rowLayout;
    private Context             context;

    UdacityItemClickListener    udacityItemClickListener;

   /*
    * Class Name: UdacityViewHolder
    * Description: Implement a view holder pattern
    *
    */

    public static class UdacityViewHolder extends RecyclerView.ViewHolder {
        LinearLayout            udacityLayout;
        TextView                courseName;
//        TextView                courseKey;
//        TextView                courseSubtitle;
//        TextView                courseInfo;
//        TextView                courseDescription;
        ImageView               courseImage;


       /*
        * Name: UdacityViewHolder
        * @return void
        *  Description: Initiate the view holder class values
        *
        */

        public UdacityViewHolder (View v) {
            super(v);

            udacityLayout       = (LinearLayout) v.findViewById(R.id.udacity_layout);
            courseName         = (TextView)v.findViewById(R.id.title);
//            courseKey           = (TextView)v.findViewById(R.id.key);
//            courseSubtitle      = (TextView)v.findViewById(R.id.subtitle);
//            courseInfo          = (TextView)v.findViewById(R.id.course_info);
//            courseDescription   = (TextView)v.findViewById(R.id.description);
            courseImage         = (ImageView)v.findViewById(R.id.image);
        }
    }

   /*
    * Name: UdacityAdapter
    * @return void
    *  Description: Initiate the values for the adapter
    *
    */

    public UdacityAdapter(List<TracksData> tracks, int rowLayout, Context context) {
        this.tracks     = tracks;
        this.rowLayout  = rowLayout;
        this.context    = context;
    }

    /*
     * Name: UdacityAdapter.UdacityViewHolder
     * @return View (UdacityViewHolder)
     *  Description: Initiate the view
     *
     */

    @Override
    public UdacityAdapter.UdacityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        final UdacityViewHolder mViewHolder = new UdacityViewHolder(view);

        return mViewHolder;
    }

    /*
     * Name: onBindViewHolder
     * @return void
     *  Description: Populate the view
     *  Comment: Will need to refactored, once I decide how to model the Udacity data.
     *
     */
    @Override
    public void onBindViewHolder(UdacityViewHolder holder, final int position) {
        holder.courseName.setText(tracks.get(position).getName() );
//        holder.courseKey.setText("Course ID: " + tutorials.get(position).getCourseKey() + " - Level: " + tutorials.get(position).getCourseLevel());
//        holder.courseSubtitle.setText(tutorials.get(position).getCourseSubTitle());
//        String info = "Course duration: " + tutorials.get(position).getCourseDuration()
//               + " " + tutorials.get(position).getCourseDurationUnit();

//        holder.courseInfo.setText(info);
//        holder.courseDescription.setText(tutorials.get(position).getCourseDescription());

        // TODO: Refactor color coding of skill level
//
//        // Set the background to match the level
//        switch (tutorials.get(position).getCourseLevel()) {
//            case "beginner":        // OFf White
//                holder.courseTitle.setBackgroundColor(Color.parseColor("#FFDEAD"));
//                holder.courseKey.setBackgroundColor(Color.parseColor("#FFDEAD"));
//                break;
//            case "intermediate":    // Yellow
//                holder.courseTitle.setBackgroundColor(Color.parseColor("#FFFACD"));
//                holder.courseKey.setBackgroundColor(Color.parseColor("#FFFACD"));
//                break;
//            case "advanced":        // Blue
//                holder.courseTitle.setBackgroundColor(Color.parseColor("#AFEEEE"));
//                holder.courseKey.setBackgroundColor(Color.parseColor("#AFEEEE"));
//                break;
//            default:
//                // Leave the default colour
//                break;
//        }


        // TODO: Refactor image selection for courses

        // For locally held resources
        switch(tracks.get(position).getName()) {
            case "Software Engineering":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd000));
                break;
            case "Web Development":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd001));
                break;
            case "iOS":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd004));
                break;
            case "Georgia Tech Masters in CS":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd003));
                break;
            case "Non-Tech":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd008));
                break;
            case "Data Science":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd013));
                break;
            case "Android":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd801));
                break;
            default:
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd002));
                break;
        }


        // TODO: UDACITY jsonReponse has inconsistent images available.
        // Currently using the images from the website rather than the jsonResponse as this seems
        // to be updated more frequently.

//        holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd000));

        // Add the image using Picasso
//        String courseImage = tutorials.get(position).getCourseImage();

//        if (courseImage.length() > 0) {
//            Picasso.with(this.context)
//                    .load(tutorials.get(position).getCourseImage())
//                    .into(holder.courseImage);
//
//        }

//        holder.setClickListener(new ItemClickListener() {
//            @Override
//            public void onClick(View view, int position, boolean isLongClick) {
//                if (isLongClick) {
//                    Toast.makeText(context, "#" + position + " - " + tutorials.get(position).getCourseKey() + " (Long click)", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(context, "#" + position + " - " + tutorials.get(position).getCourseKey() + " (Short click)", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        // Set up a listener
//        holder.setClickListener(new ItemClickListener() {
//            @Override
//            public void onClick(View view, int position, boolean isLongClick) {
//                    Toast.makeText(context, "#" + position + " - " + tutorials.get(position).getCourseKey() + " (Long click)", Toast.LENGTH_LONG).show();
//
//            }
//        });

    }

   /*
    * Name: getItemCount
    * @return int
    *  Description: Find the size of the items passed for the tutorials object
    *
    */

    @Override
    public int getItemCount() {
        return tracks.size();
    }
}
