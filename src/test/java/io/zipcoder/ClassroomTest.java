package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

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

    @Test
    public void removeStudentTest(){
        // Given
        String firstName = "Caleb", lastName = "Powell";
        Classroom cr = new Classroom(4);
        cr.addStudent(new Student());
        cr.addStudent(new Student(firstName, lastName, new Double[0]));
        cr.addStudent(new Student());

        // When
        Boolean successful = cr.removeStudent(firstName, lastName);

        // Assert
        Assert.assertTrue(successful);
    }

    @Test
    public void removeStudentTestNone() {
        // Given
        String firstName = "Caleb", lastName = "Powell";
        Classroom cr = new Classroom(4);
        cr.addStudent(new Student());
        cr.addStudent(new Student());
        cr.addStudent(new Student());

        // When
        Boolean successful = cr.removeStudent(firstName, lastName);

        // Assert
        Assert.assertFalse(successful);
    }

    @Test public void orderStudentTest(){
        // Given
        Student s1 = new Student("a", "b", new Double[] {100d, 100d, 100d});
        Student s2 = new Student("b", "c", new Double[] {200d, 120d, 120d});
        Student s3 = new Student("d", "e", new Double[] {100d, 10d, 10d});
        Classroom cr = new Classroom(new Student[] {s1, s2, s3});

        // When
        cr.orderStudents();

        // Assert
        Assert.assertTrue(cr.getStudents()[0] == s3);
        Assert.assertTrue(cr.getStudents()[1] == s1);
        Assert.assertTrue(cr.getStudents()[2] == s2);
    }

    @Test public void orderStudentTestSameScore(){
        // Given
        Student s1 = new Student("z", "x", new Double[] {100d, 100d, 100d});
        Student s2 = new Student("b", "c", new Double[] {100d, 100d, 100d});
        Student s3 = new Student("d", "e", new Double[] {100d, 100d, 100d});
        Classroom cr = new Classroom(new Student[] {s1, s2, s3});

        // When
        cr.orderStudents();

        // Assert
        Assert.assertTrue(cr.getStudents()[0] == s2);
        Assert.assertTrue(cr.getStudents()[1] == s3);
        Assert.assertTrue(cr.getStudents()[2] == s1);
    }

    @Test
    public void getGradebookTest(){
        // Given
        Student s1 = new Student("z", "x", new Double[] {90d, 100d, 100d});
        Student s2 = new Student("b", "c", new Double[] {80d, 100d, 100d});
        Student s3 = new Student("d", "e", new Double[] {50d, 100d, 100d});
        Student s4 = new Student("t", "e", new Double[] {10d, 100d, 100d});
        Student s5 = new Student("u", "e", new Double[] {88d, 100d, 100d});
        Student s6 = new Student("m", "e", new Double[] {100d, 100d, 100d});
        Classroom cr = new Classroom(new Student[] {s1, s2, s3, s4, s5, s6});

        // When
        HashMap<Student, String> grades = cr.getGradebook();

        // Assert
        Assert.assertEquals("D", grades.get(s4));
        Assert.assertEquals("A", grades.get(s6));
    }

}
