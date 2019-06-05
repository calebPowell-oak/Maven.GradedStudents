package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void x(){
        // Given

        // When

        // Assert
    }

    @Test
    public void getAverageExamScoreTest(){
        // Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("S", "1", s1Scores);
        Student s2 = new Student("S", "2", s2Scores);

        Student[] students = new Student[] {s1, s2};
        Classroom cr = new Classroom(students);

        // When
        Double actual = cr.getAverageExamScore();
        Double expected = 125.0;

        // Assert
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void addStudentTest(){
        // Given
        Student[] students = {new Student(), new Student(), new Student(), null};
        Classroom cr = new Classroom(students);

        // When
        Boolean successful = cr.addStudent(new Student());

        // Assert
        Assert.assertTrue(successful);
    }

    @Test
    public void addStudentPastMaxTest(){
        // Given
        Classroom cr = new Classroom(0);

        // When
        Boolean successful = cr.addStudent(new Student());

        // Assert
        Assert.assertFalse(successful);
    }
}
