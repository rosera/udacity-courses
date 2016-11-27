package com.processisolation.rosera.udacitycurated.Main;

/**
 * Created by rosera on 02/11/16.
 */

public class UdacityData {

    private String  courseInstructors;
    private String  courseSubTitle;
    private String  courseKey;
    private String  courseImage;
    private String  courseTitle;
    private String  courseLevel;
    private String  courseDurationUnit;
    private int     courseDuration;
    private String  courseHomePage;
    private boolean courseFullyAvailable;


    private String  courseDescription;

   /*
    * Name: UdacityData
    * @return void
    *  Description: Initiate memory construct with data from the Udacity API
    *
    */

    public UdacityData(String courseSubTitle, String courseKey, String courseImage,
        String courseTitle, String courseLevel, String courseDurationUnit, int courseDuration,
        String courseHomePage, boolean courseFullyAvailable, String courseDescription) {

        this.courseSubTitle         = courseSubTitle;
        this.courseKey              = courseKey;
        this.courseImage            = courseImage;
        this.courseTitle            = courseTitle;
        this.courseLevel            = courseLevel;
        this.courseDurationUnit     = courseDurationUnit;
        this.courseDuration         = courseDuration;
        this.courseHomePage         = courseHomePage;
        this.courseFullyAvailable   = courseFullyAvailable;
        this.courseDescription      = courseDescription;
    }


   /*
    * Name: (General) getters for object
    * @return
    *  Description: Access private member variables
    *
    */

    public String getCourseSubTitle() {
        return courseSubTitle;
    }

    public String getCourseKey() {
        return courseKey;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public String getCourseDurationUnit() {
        return courseDurationUnit;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public String getCourseHomePage() {
        return courseHomePage;
    }

    public boolean isCourseFullyAvailable() {
        return courseFullyAvailable;
    }

    public String getCourseDescription() {
        return courseDescription;
    }
}
