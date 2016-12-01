package com.processisolation.rosera.udacitycurated.Main;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rosera on 09/11/16.
 */

public class DegreeDB extends RealmObject {

//    @PrimaryKey
    private String  courseKey;
    private String  courseImage;
    private String  courseTitle;
    private String  courseSubTitle;
    private String  courseLevel;
    private String  courseDurationUnit;
    private int     courseDuration;
    private String  courseHomePage;
    private int courseFullyAvailable;
    private String  courseSyllabus;
    private String  courseInstructors;
    private String  courseDescription;

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseKey() {
        return courseKey;
    }

    public void setCourseKey(String courseKey) {
        this.courseKey = courseKey;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseSubTitle() {
        return courseSubTitle;
    }

    public void setCourseSubTitle(String courseSubTitle) {
        this.courseSubTitle = courseSubTitle;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getCourseDurationUnit() {
        return courseDurationUnit;
    }

    public void setCourseDurationUnit(String courseDurationUnit) {
        this.courseDurationUnit = courseDurationUnit;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseHomePage() {
        return courseHomePage;
    }

    public void setCourseHomePage(String courseHomePage) {
        this.courseHomePage = courseHomePage;
    }

    public int getCourseFullyAvailable() {
        return courseFullyAvailable;
    }

    public void setCourseFullyAvailable(int courseFullyAvailable) {
        this.courseFullyAvailable = courseFullyAvailable;
    }

    public String getCourseSyllabus() {
        return courseSyllabus;
    }

    public void setCourseSyllabus(String courseSyllabus) {
        this.courseSyllabus = courseSyllabus;
    }

    public String getCourseInstructors() {
        return courseInstructors;
    }

    public void setCourseInstructors(String courseInstructors) {
        this.courseInstructors = courseInstructors;
    }

}
