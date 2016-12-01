package com.processisolation.rosera.udacitycurated.Main;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rosera on 02/11/16.
 */

public class UdacityData {

    private String  courseSubTitle;
    private String  courseKey;
    private String  courseImage;
    private String  courseTitle;
    private String  courseLevel;
    private String  courseDurationUnit;
    private int     courseDuration;
    private String  courseHomePage;
    private int courseFullyAvailable;
    private String  courseSyllabus;
    private String  courseInstructors;
    private String  courseSummary;
    private String  courseDescription;

   /*
    * Name: UdacityData
    * @return void
    *  Description: Initiate memory construct with data from the Udacity API
    *
    */

    public UdacityData(String courseSubTitle, String courseKey, String courseImage,
        String courseTitle, String courseLevel, String courseDurationUnit, int courseDuration,
        String courseHomePage, int courseFullyAvailable, String courseSummary, String courseDescription,
                       String courseSyllabus, String courseInstructors) {

        this.courseSubTitle         = courseSubTitle;
        this.courseKey              = courseKey;
        this.courseImage            = courseImage;
        this.courseTitle            = courseTitle;
        this.courseLevel            = courseLevel;
        this.courseDurationUnit     = courseDurationUnit;
        this.courseDuration         = courseDuration;
        this.courseHomePage         = courseHomePage;
        this.courseFullyAvailable   = courseFullyAvailable;
        this.courseSummary          = courseSummary;
        this.courseDescription      = courseDescription;
        this.courseSyllabus         = courseSyllabus;
        this.courseInstructors      = courseInstructors;
    }


   /*
    * Name: (General) getters for object
    * @return
    *  Description: Access private member variables
    *
    */

    public String getCourseKey() {
        return courseKey;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseSubTitle() {
        return courseSubTitle;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public String getCourseLevel() { return courseLevel;    }

    public String getCourseDurationUnit() {
        return courseDurationUnit;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public String getCourseHomePage() {
        return courseHomePage;
    }

    public int isCourseFullyAvailable() {
        return courseFullyAvailable;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseSyllabus() {
        return courseSyllabus;
    }

    public String getCourseInstructors() {
        return courseInstructors;
    }

    public String getCourseSummary() {
        return courseSummary;
    }



    public void setCourseSubTitle(String courseSubTitle) {
        this.courseSubTitle = courseSubTitle;
    }

    public void setCourseKey(String courseKey) {
        this.courseKey = courseKey;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public void setCourseDurationUnit(String courseDurationUnit) {
        this.courseDurationUnit = courseDurationUnit;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void setCourseHomePage(String courseHomePage) {
        this.courseHomePage = courseHomePage;
    }

    public void setCourseFullyAvailable(int courseFullyAvailable) {
        this.courseFullyAvailable = courseFullyAvailable;
    }

    public void setCourseSyllabus(String courseSyllabus) {
        this.courseSyllabus = courseSyllabus;
    }

    public void setCourseInstructors(String courseInstructors) {
        this.courseInstructors = courseInstructors;
    }

    public void setCourseSummary(String courseSummary) {
        this.courseSummary = courseSummary;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }



//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//
//        dest.writeString(this.courseSubTitle);
//        dest.writeString(this.courseKey);
//        dest.writeString(this.courseImage);
//        dest.writeString(this.courseTitle);
//        dest.writeString(this.courseLevel);
//        dest.writeString(this.courseDurationUnit);
//        dest.writeInt(this.courseDuration);
//        dest.writeString(this.courseHomePage);
//        dest.writeInt(this.courseFullyAvailable);
//        dest.writeString(this.courseDescription);
//        dest.writeString(this.courseSyllabus);
//        dest.writeString(this.courseInstructors);
//    }
}
