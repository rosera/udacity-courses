package com.processisolation.rosera.udacitycurated.Main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.processisolation.rosera.udacitycurated.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */
public class CourseDetailActivityFragment extends Fragment {

    private static View rootView;

    private String mName                            = "";
    private String mDescription                     = "";
    private static CoursesData mCourseInformation;


    public CourseDetailActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCourseInformation = (CoursesData) getActivity().getIntent().getExtras().get("Course");

        // TODO: Access the arguments passed from the parent activity
        mName            = getActivity().getIntent().getExtras().getString("Name");

        // TODO: Parse HTML code and transpose to a String
//        mDescription    = Html.fromHtml(getActivity().getIntent().getExtras().getString("Description")).toString();
        mDescription    = getActivity().getIntent().getExtras().getString("Description");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_course_detail, container, false);

        // TODO: Set up TextView - Title
        final TextView mTextViewTitle = (TextView) rootView.findViewById(R.id.title);
//        mTextViewTitle.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
        mTextViewTitle.setText(mCourseInformation.getCourseTitle());

        // TODO: Set up TextView - Duration
        final TextView mTextViewDuration = (TextView) rootView.findViewById(R.id.duration);
        mTextViewDuration.setText(mCourseInformation.getCourseDuration()
                + " " + mCourseInformation.getCourseDurationUnit());
        mTextViewDuration.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
        mTextViewDuration.setBackgroundColor(getActivity().getResources().getColor(R.color.light_green));

        // TODO: Set up TextView - Level
        final TextView mTextViewLevel = (TextView) rootView.findViewById(R.id.level);
        mTextViewLevel.setText(mCourseInformation.getCourseLevel());
        mTextViewLevel.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
        mTextViewLevel.setBackgroundColor(getActivity().getResources().getColor(R.color.light_green));


//        // TODO: Set up the TextView - Summary Header
//        final TextView mTextViewSummaryHeader = (TextView) rootView.findViewById(R.id.summary_header);
//        mTextViewSummaryHeader.setText(mCourseInformation.getCourseSummary());

        // TODO: Set up the TextView - Summary
        final TextView mTextViewSummary = (TextView) rootView.findViewById(R.id.summary);
        mTextViewSummary.setText(mCourseInformation.getCourseSummary());

        // TODO: Set up TextView - Description
        final TextView mTextViewDescription = (TextView) rootView.findViewById(R.id.what_you_need);
        String htmlAsString = mCourseInformation.getCourseRequiredKnowledge();
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);
        mTextViewDescription.setText(htmlAsSpanned);

        // TODO: Set up TextView - Summary
//        String htmlAsString = mCourseInformation.getCourseRequiredKnowledge();
//        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString);
//        mTextViewDescription.setText("Course Summary\n\n" + mCourseInformation.getCourseSummary()
//                + "\n\nWhat you need to know...\n\n" + htmlAsSpanned);



        // Card View 1

        // TODO: Set up ImageView - course image
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.courseImageView);

        if (mCourseInformation.getCourseImage().length()>0) {
            Picasso.with(this.getActivity())
                    .load(mCourseInformation.getCourseImage())
                    .placeholder(R.drawable.placeholder)
                    .noFade()
//                .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .into(imageView);
        }
        else {
            // TODO: Add alternative image when online version not available
           imageView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.no_image_sml));
        }


        // TODO: Set up the TextView - Syllabus
        final TextView mTextViewSyllabus = (TextView) rootView.findViewById(R.id.syllabus);
        mCourseInformation.setCourseSyllabus(mCourseInformation.getCourseSyllabus().replace("## ",""));
        mCourseInformation.setCourseSyllabus(mCourseInformation.getCourseSyllabus().replace("#",""));
        mTextViewSyllabus.setText(mCourseInformation.getCourseSyllabus());

        // TODO: Set up the TextView - Syllabus
        final TextView mTextViewExpectedLearning = (TextView) rootView.findViewById(R.id.expected_learning);
        mTextViewExpectedLearning.setText(mCourseInformation.getCourseExpectedLearning());




        // **************************************************************************
        // Card View - Instructors

        // TODO: Make the card contents invisible - if no contents available

        // TODO - change this to an adapter

        // TODO: Setup the information for instructors

        String[] instructors = mCourseInformation.getCourseInstructors();
        String[] instructorsImage = mCourseInformation.getCourseInstructorsImage();
        String[] instructorsBio = mCourseInformation.getCourseInstructorsBio();


        // Find Views
        final TextView mTextViewInstructor = (TextView) rootView.findViewById(R.id.instructor);
        final TextView mTextViewBio = (TextView) rootView.findViewById(R.id.instructor_bio);
        final ImageView mImageViewImage = (ImageView) rootView.findViewById(R.id.instructor_image);

        int sizeArray = instructors.length;

        if (sizeArray>0) {
            // TODO: Refactor this garbage
            mTextViewInstructor.setText(instructors[0]);

            // TODO: Set up TextView - Instructor bio
            htmlAsString = instructorsBio[0];
            htmlAsSpanned = Html.fromHtml(htmlAsString);
            mTextViewBio.setText(htmlAsSpanned);

            // TODO: Set up ImageView - Instructor image
            if (instructorsImage[0].length() > 0) {
                Picasso.with(this.getActivity())
                        .load(instructorsImage[0])
                        .placeholder(R.drawable.no_image_sml)
                        .noFade()
//                .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .into(mImageViewImage);
            }
            else {
                // TODO: Add alternative image when online version not available
                mImageViewImage.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.no_image_sml));
            }
        } else {
            // Make the content invisible
            mTextViewInstructor.setVisibility(View.INVISIBLE);
            mTextViewBio.setVisibility(View.INVISIBLE);
//            mImageViewImage.setVisibility(View.INVISIBLE);
        }

        // TODO: Make the card contents invisible - if no contents available

        final TextView mTextViewInstructor2 = (TextView) rootView.findViewById(R.id.instructor2);
        final TextView mTextViewBio2 = (TextView) rootView.findViewById(R.id.instructor_bio2);
        final ImageView mImageViewImage2 = (ImageView) rootView.findViewById(R.id.instructor_image2);

        // Card View - Instructor(s)

        if (sizeArray > 1) {

            // TODO: Set up TextView - Instructor name
//        String[] instructors2 = mCourseInformation.getCourseInstructors();
            mTextViewInstructor2.setText(instructors[1]);

            // TODO: Set up TextView - Instructor bio

//        String[] instructorsBio = mCourseInformation.getCourseInstructorsBio();
            htmlAsString = instructorsBio[1];
            htmlAsSpanned = Html.fromHtml(htmlAsString);
            mTextViewBio2.setText(htmlAsSpanned);

            // TODO: Set up ImageView - Instructor image

//        String[] instructorsImage = mCourseInformation.getCourseInstructorsImage();

            if (instructorsImage[1].length() > 0) {
                Picasso.with(this.getActivity())
                        .load(instructorsImage[1])
                        .placeholder(R.drawable.no_image_sml)
                        .noFade()
//                .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .into(mImageViewImage2);
            } else {
                // TODO: Add alternative image when online version not available
                mImageViewImage2.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.no_image_sml));
            }

        }
        else {
            // Make the content invisible
            mTextViewInstructor2.setVisibility(View.INVISIBLE);
            mTextViewBio2.setVisibility(View.INVISIBLE);
//            mImageViewImage2.setVisibility(View.INVISIBLE);
        }

        // TODO: Make the card contents invisible

        return rootView;
    }
}
