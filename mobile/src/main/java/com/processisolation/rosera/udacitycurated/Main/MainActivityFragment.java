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
            mCourseImageArray = getActivity().getIntent().getExtras().getStringArray("Images");

            // TODO: Debug check
            int i = mCourseArray.length;
            Log.i("Debug", "i =  " + i);

            int y = mCourseImageArray.length;
            Log.i("Debug", "y =  " + y);

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

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        layoutManager.setGapStrategy(
                StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        // TODO: Allocate memory for the RecyclerView
        final String[] courseArray  = {
                                "Course1",
                                "Course2",
                                "Course3",
                                "Course4",
                                "Course5",
                                "Course6",
                                "Course7",
                                "Course8",
                                "Course9",
                                "Course10",
                                "Course11",
                                "Course12",
                                "Course13"};

        int[] drawables     = { R.drawable.nd000,
                                R.drawable.nd001,
                                R.drawable.nd002,
                                R.drawable.nd003,
                                R.drawable.nd004,
                                R.drawable.nd006,
                                R.drawable.nd008,
                                R.drawable.nd009,
                                R.drawable.nd013,
                                R.drawable.nd017,
                                R.drawable.nd801,
                                R.drawable.nd803,
                                R.drawable.nd889};

        // TODO: Add items to the screen
//        mRecyclerView.setAdapter(new CourseAdapter(courseArray, drawables, R.layout.gridview_image, getActivity()));
        mRecyclerView.setAdapter(new CourseAdapter(mCourseArray, mCourseImageArray, R.layout.gridview_image, getActivity()));

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
                        .putExtra("Name", mName)
                        .putExtra("Description", mDescription);

                // Commence the new intent
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
