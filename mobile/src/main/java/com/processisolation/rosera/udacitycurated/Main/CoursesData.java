package com.processisolation.rosera.udacitycurated.Main;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by rosera on 27/11/16.
 */

public class CoursesData implements Parcelable {

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
    private String  courseExpectedLearning;
    private String  courseSummary;
    private String  courseDescription;
    private String  courseRequiredKnowledge;
    private String[]  courseInstructors;
    private String[]  courseInstructorsImage;
    private String[]  courseInstructorsBio;



    public CoursesData(String courseSubTitle, String courseKey, String courseImage,
                       String courseTitle, String courseLevel, String courseDurationUnit,
                       int courseDuration, String courseHomePage, int courseFullyAvailable,
                       String courseSummary, String courseDescription, String courseSyllabus,
                       String courseExpectedLearning, String courseInstructors[],
                       String courseInstructorsImage[], String courseInstructorsBio[],
                       String courseRequiredKnowledge) {

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
        this.courseInstructorsImage      = courseInstructorsImage;
        this.courseInstructorsBio      = courseInstructorsBio;
        this.courseRequiredKnowledge = courseRequiredKnowledge;
        this.courseExpectedLearning = courseExpectedLearning;
    }

    public String getCourseSubTitle() {
        return courseSubTitle;
    }

    public void setCourseSubTitle(String courseSubTitle) {
        this.courseSubTitle = courseSubTitle;
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


    public String[] getCourseInstructorsBio() {
        return courseInstructorsBio;
    }

    public void setCourseInstructorsBio(String[] courseInstructorsBio) {
        this.courseInstructorsBio = courseInstructorsBio;
    }

    public String getCourseExpectedLearning() {
        return courseExpectedLearning;
    }

    public void setCourseExpectedLearning(String courseExpectedLearning) {
        this.courseExpectedLearning = courseExpectedLearning;
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

    public String[] getCourseInstructors() {
        return courseInstructors;
    }

    public void setCourseInstructors(String[] courseInstructors) {
        this.courseInstructors = courseInstructors;
    }

    public String getCourseSummary() {
        return courseSummary;
    }

    public void setCourseSummary(String courseSummary) {
        this.courseSummary = courseSummary;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseRequiredKnowledge() {
        return courseRequiredKnowledge;
    }

    public void setCourseRequiredKnowledge(String courseRequiredKnowledge) {
        this.courseRequiredKnowledge = courseRequiredKnowledge;
    }

    public String[] getCourseInstructorsImage() {
        return courseInstructorsImage;
    }

    public void setCourseInstructorsImage(String[] courseInstructorsImage) {
        this.courseInstructorsImage = courseInstructorsImage;
    }


    public static final Parcelable.Creator<CoursesData> CREATOR = new Creator<CoursesData>() {
        @Override
        public CoursesData createFromParcel(Parcel source) {
            return new CoursesData(source);
        }

        @Override
        public CoursesData[] newArray(int size) {
            return new CoursesData[0];

        }
    };


    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(courseSubTitle);
        dest.writeString(courseKey);
        dest.writeString(courseImage);
        dest.writeString(courseTitle);
        dest.writeString(courseLevel);
        dest.writeString(courseDurationUnit);
        dest.writeInt(courseDuration);
        dest.writeString(courseHomePage);
        dest.writeInt(courseFullyAvailable);
        dest.writeString(courseSummary);
        dest.writeString(courseDescription);
        dest.writeString(courseSyllabus);
        dest.writeString(courseExpectedLearning);
        dest.writeString(courseRequiredKnowledge);

        dest.writeStringArray(courseInstructors);
        dest.writeStringArray(courseInstructorsImage);
        dest.writeStringArray(courseInstructorsBio);


    }

    private CoursesData(Parcel in) {
        this.courseSubTitle = in.readString();
        this.courseKey = in.readString();
        this.courseImage = in.readString();
        this.courseTitle = in.readString();
        this.courseLevel = in.readString();
        this.courseDurationUnit = in.readString();
        this.courseDuration = in.readInt();
        this.courseHomePage = in.readString();
        this.courseFullyAvailable = in.readInt();
        this.courseSummary = in.readString();
        this.courseDescription = in.readString();
        this.courseSyllabus = in.readString();
        this.courseExpectedLearning = in.readString();
        this.courseRequiredKnowledge = in.readString();

        // TODO: Hmm - hope this works!
        this.courseInstructors = in.createStringArray();
        this.courseInstructorsImage = in.createStringArray();
        this.courseInstructorsBio = in.createStringArray();
    }

}
