package com.processisolation.rosera.udacitycurated;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by rosera on 02/11/16.
 */

public class UdacityAdapter extends RecyclerView.Adapter<UdacityAdapter.UdacityViewHolder>{

    private List<UdacityData>   tutorials;
    private int                 rowLayout;
    private Context             context;

   /*
    * Class Name: UdacityViewHolder
    * Description: Implement a view holder pattern
    *
    */

    public static class UdacityViewHolder extends RecyclerView.ViewHolder {
        LinearLayout            udacityLayout;
        TextView                courseTitle;
        TextView                courseKey;
        TextView                courseSubtitle;
        TextView                courseDescription;
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
            courseTitle         = (TextView)v.findViewById(R.id.title);
            courseKey           = (TextView)v.findViewById(R.id.key);
            courseSubtitle      = (TextView)v.findViewById(R.id.subtitle);
            courseDescription   = (TextView)v.findViewById(R.id.description);
            courseImage         = (ImageView)v.findViewById(R.id.image);
        }
    }

   /*
    * Name: UdacityAdapter
    * @return void
    *  Description: Initiate the values for the adapter
    *
    */

    public UdacityAdapter(List<UdacityData> tutorials, int rowLayout, Context context) {
        this.tutorials  = tutorials;
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

        return new UdacityViewHolder(view);
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
        holder.courseTitle.setText(tutorials.get(position).getCourseTitle());
        holder.courseKey.setText("Course Key: " + tutorials.get(position).getCourseKey());
        holder.courseSubtitle.setText(tutorials.get(position).getCourseSubTitle());
        holder.courseDescription.setText(tutorials.get(position).getCourseDescription());

        // For locally held resources
        switch(tutorials.get(position).getCourseKey()) {
            case "nd000":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd000));
                break;
            case "nd001":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd001));
                break;
            case "nd002":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd002));
                break;
            case "nd003":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd003));
                break;
            case "nd004":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd004));
                break;
            case "nd006":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd006));
                break;
            case "nd008":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd008));
                break;
            case "nd009":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd009));
                break;
            case "nd013":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd013));
                break;
            case "nd017":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd017));
                break;
            case "nd801":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd801));
                break;
            case "nd803":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd803));
                break;
            case "nd889":
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd889));
                break;
            default:
                holder.courseImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nd000));
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

    }

   /*
    * Name: getItemCount
    * @return int
    *  Description: Find the size of the items passed for the tutorials object
    *
    */

    @Override
    public int getItemCount() {
        return tutorials.size();
    }
}
