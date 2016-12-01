package com.processisolation.rosera.udacitycurated.Main;

import java.util.ArrayList;

/**
 * Created by rosera on 26/11/16.
 */

public class TracksData {

    // Member variables
    private String  mName;
    private String  mDescription;
    private String[] mCourseId;
    private String[] mCourseImages;
    private ArrayList<CoursesData> mCourseList;


    private String[] mCourseName;



    public TracksData(String trackName, String trackDescription, String[] trackCourses,
                      String[] courseImages, String[] courseName, ArrayList<CoursesData> courseList) {
        this.mName          = trackName;
        this.mDescription   = trackDescription;
        this.mCourseId      = trackCourses;
        this.mCourseImages  = courseImages;
        this.mCourseName    = courseName;
        this.mCourseList    = courseList;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

    public void setDescription(String Description) {
        this.mDescription = Description;
    }

    public String[] getCourses() {return mCourseId; }

    public void setCourses(String[] Courses) {this.mCourseId = Courses;}

    public String[] getCourseImages() {return mCourseImages; }

    public void setmCourseImages(String[] CourseImages) {this.mCourseImages = CourseImages;}

    public String[] getCourseName() {
        return mCourseName;
    }

    public void setCourseName(String[] mCourseName) {
        this.mCourseName = mCourseName;
    }

    public ArrayList<CoursesData> getCourseList() {
        return mCourseList;
    }

    public void setCourseList(ArrayList<CoursesData> mCourseList) {
        this.mCourseList = mCourseList;
    }

}
