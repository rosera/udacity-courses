package com.processisolation.rosera.udacitycurated.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by rosera on 06/11/16.
 */

// Ref: Mastering Android Application Development p100
// Viewholder independent code for RecyclerView click.

public class UdacityItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;
    private GestureDetector     mGestureDectector;


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());

        if (child !=null && mListener != null && mGestureDectector.onTouchEvent(e)) {
            mListener.onItemClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }



    public UdacityItemClickListener(Context context, final RecyclerView recyclerView,
                                    OnItemClickListener listener) {
        mListener = listener;

        mGestureDectector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
           @Override
            public boolean onSingleTapUp(MotionEvent e) {
               return true;
           }

        });
    }

}
