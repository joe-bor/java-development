package com.pluralsight.week7.streams.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Course implements Comparable {
    private String title;
    private int studyPoints;
    private int maxNumOfStudents;



    @Override
    public int compareTo(Object o) {
        if (o instanceof Course course) {
            return this.title.compareTo(course.getTitle());
        }
        return 0;
    }

    public static final Comparator<Course> BY_TITLE = Comparator.comparing(Course::getTitle);
}
