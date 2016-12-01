package com.processisolation.rosera.udacitycurated.Main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.processisolation.rosera.udacitycurated.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rosera on 24/11/16.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private int         rowLayout;
    private Context     context;
    private String[]    mTitles;
    private String[]    mImages;
    private ArrayList<CoursesData> mCoursesDataArrayList;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout    udacityLayout;
        TextView        courseTitle;
        ImageView       courseImage;
        TextView        courseLevel;

        public ViewHolder (View v) {
            super(v);

            udacityLayout   = (LinearLayout) v.findViewById(R.id.course_layout);
            courseTitle     = (TextView)v.findViewById(R.id.courseTextView);
            courseImage     = (ImageView)v.findViewById(R.id.courseImageView);
            courseLevel     = (TextView)v.findViewById(R.id.course_level);
        }
    }

//    public CourseAdapter(String[] coursesTitles, String[] images, int rowLayout, Context context) {

    public CourseAdapter(ArrayList<CoursesData> courseList, int rowLayout, Context context) {
//        this.mTitles    = coursesTitles;
//        this.mImages    = images;
        this.mCoursesDataArrayList = courseList;
        this.rowLayout  = rowLayout;
        this.context    = context;
    }

    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        final CourseAdapter.ViewHolder mViewHolder = new CourseAdapter.ViewHolder(view);

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.courseTitle.setText(mTitles[position].toString());
        try {
//            if (mCoursesDataArrayList.get(position).getCourseTitle() != null)
            CoursesData tempCourseData = mCoursesDataArrayList.get(position);
            String tempText = tempCourseData.getCourseTitle();
            //            int i = mCourseArray.length;
//            Log.i("Debug", "i =  " + i);
                holder.courseTitle.setText(mCoursesDataArrayList.get(position).getCourseTitle());
//            else {
//                int i =0;
//            }

    //        holder.courseImage.setImageDrawable(context.getResources().getDrawable(mImages[position]));

            // TODO: Dynamically create the string for the identifier
    //        int id = context.getResources().getIdentifier("drawable/" + mImages[position], null, null);
    //
    //        holder.courseImage.setImageDrawable(context.getResources().getDrawable(id));

    //        // TODO: Use Picasso to fetch and load images into the ImageView
            if (mCoursesDataArrayList.get(position).getCourseImage().length()>0) {
                Picasso.with(this.context)
                        .load(mCoursesDataArrayList.get(position).getCourseImage())
                        .placeholder(R.drawable.placeholder)
                        .noFade()
    //                .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .into(holder.courseImage);
            }
            else {
                // TODO: Add alternative image when online version not available
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.no_image));

            }

            switch (mCoursesDataArrayList.get(position).getCourseLevel()) {
                case "beginner":
                    holder.courseLevel.setTextColor(context.getResources().getColor(R.color.colorWhite));
                    holder.courseLevel.setBackgroundColor(context.getResources().getColor(R.color.light_green));
                    holder.courseLevel.setText(mCoursesDataArrayList.get(position).getCourseLevel());
                    break;
                case "intermediate":
                    holder.courseLevel.setTextColor(context.getResources().getColor(R.color.colorWhite));
                    holder.courseLevel.setBackgroundColor(context.getResources().getColor(R.color.teal));

                    holder.courseLevel.setText(mCoursesDataArrayList.get(position).getCourseLevel());
                    break;
                case "advanced":
    //                holder.courseLevel.setTextColor(context.getResources().getColor(R.color.colorRed));
                    holder.courseLevel.setTextColor(context.getResources().getColor(R.color.colorWhite));
                    holder.courseLevel.setBackgroundColor(context.getResources().getColor(R.color.colorRed));
                    holder.courseLevel.setText(mCoursesDataArrayList.get(position).getCourseLevel());
                    break;
                default:
                    holder.courseLevel.setTextColor(context.getResources().getColor(R.color.colorWhite));
                    holder.courseLevel.setBackgroundColor(context.getResources().getColor(R.color.colorGreyLight));

                    holder.courseLevel.setText("Not defined");
                    break;
            }

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

   /*
    * Name: getItemCount
    * @return int
    *  Description: Find the size of the items passed for the tutorials object
    *
    */

    @Override
    public int getItemCount() {
//        return mTitles.length;
        return mCoursesDataArrayList.size();
    }

}
