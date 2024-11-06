package com.pluralsight.week7.streams.exercise;

import java.util.Comparator;

public class Course implements Comparable {
    private String title;
    private int studyPoints;
    private int maxNumOfStudents;

    public Course(String title, int studyPoints, int maxNumOfStudents) {
        this.title = title;
        this.studyPoints = studyPoints;
        this.maxNumOfStudents = maxNumOfStudents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
    }

    public int getMaxNumOfStudents() {
        return maxNumOfStudents;
    }

    public void setMaxNumOfStudents(int maxNumOfStudents) {
        this.maxNumOfStudents = maxNumOfStudents;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Course course) {
            return this.title.compareTo(course.getTitle());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", studyPoints=" + studyPoints +
                ", maxNumOfStudents=" + maxNumOfStudents +
                '}';
    }

    public static final Comparator<Course> BY_TITLE = Comparator.comparing(Course::getTitle);
}
