package com.processisolation.rosera.udacitycurated.Main;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.processisolation.rosera.udacitycurated.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static View rootView;
    private RecyclerView mRecyclerView = null;
//    private static String mId = "";
    private static String mName = "";
    private static String mDescription = "";
    private static String[] mCourseArray;
    private static String[] mCourseImageArray;
    private static String[] mCourseNameArray;

    private static ArrayList<CoursesData> mCoursesInformation;
//    private Test mCoursesInformation;



    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: Access the arguments passed from the parent activity
//        if (getActivity().getIntent().getExtras() != null)
//        if (savedInstanceState != null) {
//            mId = savedInstanceState.getString("ID");
//            mTitle = savedInstanceState.getString("Title");
//            mDescription = savedInstanceState.getString("Description");
//        } else
        if (getActivity().getIntent().getExtras() != null) {
//            mId             = getActivity().getIntent().getExtras().getString("ID");
            mName          = getActivity().getIntent().getExtras().getString("Name");

            // TODO: Parse HTML code and transpose to a String
//            mDescription    = Html.fromHtml(getActivity().getIntent().getExtras().getString("Description")).toString();
            mDescription    = getActivity().getIntent().getExtras().getString("Description");

            mCourseArray = getActivity().getIntent().getExtras().getStringArray("Courses");
//            mCourseImageArray = getActivity().getIntent().getExtras().getStringArray("Images");
//            mCourseNameArray = getActivity().getIntent().getExtras().getStringArray("Title");
//            mCoursesInformation = (Test) getActivity().getIntent().getExtras().get("CourseList");
//            mCoursesInformation = getActivity().getIntent().getParcelableArrayListExtra("CourseList");
//            mCoursesInformation = getActivity().getIntent().getExtras().getParcelableArrayList("CourseList");

            mCoursesInformation = getActivity().getIntent().getExtras().getParcelableArrayList("CourseList");

            ArrayList<CoursesData> tempArrayData = mCoursesInformation;
            CoursesData tempData2;


            // TODO: Show the data passed
            for (int i=0; i < tempArrayData.size(); i++) {
                tempData2 = tempArrayData.get(i);

                i = i;
            }





            // TODO: Debug check
            int i = mCourseArray.length;
            Log.i("Debug", "i =  " + i);

//            int y = mCourseImageArray.length;
//            Log.i("Debug", "y =  " + y);

        }
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//
//        super.onActivityCreated(savedInstanceState);
//
//        if (savedInstanceState != null) {
//            mId = savedInstanceState.getString("ID");
//            mTitle = savedInstanceState.getString("Title");
//            mDescription = savedInstanceState.getString("Description");
//        }
//
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // TODO: Set up TextView - Title
        TextView mTextViewTitle = (TextView) rootView.findViewById(R.id.Title);
        mTextViewTitle.setText(mName);

        // TODO: Set up TextView - Description
        TextView mTextViewDescription = (TextView) rootView.findViewById(R.id.Description);
        mTextViewDescription.setText(mDescription);

        // TODO: Set up RecyclerView
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.course_recyclerview);

        // TODO: Check the device density to correct number of grid items
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);

        layoutManager.setGapStrategy(
                StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        // TODO: Add items to the screen
//        mRecyclerView.setAdapter(new CourseAdapter(courseArray, drawables, R.layout.gridview_image, getActivity()));
//        mRecyclerView.setAdapter(new CourseAdapter(mCourseNameArray, mCourseImageArray, R.layout.gridview_image, getActivity()));
        mRecyclerView.setAdapter(new CourseAdapter(mCoursesInformation, R.layout.gridview_image, getActivity()));

        // Add a listener for the RecyclerView - Ref: Mastering Android Application Development p100
        mRecyclerView.addOnItemTouchListener(new UdacityItemClickListener(getActivity(),
                mRecyclerView, new UdacityItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

//                Toast.makeText(getActivity(), "RecycleView item selected: " + courseArray[position],
//                        Toast.LENGTH_LONG).show();

                // Initiate a new activity for the onscreen item clicked
                Intent intent = new Intent(getActivity(), CourseDetailActivity.class)
//                        .putExtra("ID", mUdacityDegreesInformation.get(position).getCourseKey())
                        .putExtra("Course", mCoursesInformation.get(position))
                        .putExtra("Name", mName)
                        .putExtra("Image", mCoursesInformation.get(position).getCourseImage())
                        .putExtra("Description", mDescription);

                // Commence the new intent - Course detail summary
                startActivity(intent);
            }
        }));

        return rootView;
    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        // Call the superclass
//        super.onSaveInstanceState(savedInstanceState);
//
//        savedInstanceState.putString("ID", mId);
//        savedInstanceState.putString("Title", mTitle);
//        savedInstanceState.putString("Description", mDescription);
//    }

}
